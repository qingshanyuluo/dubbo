package xyz.lennon.dubbo.register;

import xyz.lennon.dubbo.framework.URL;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RemoteMapRegister {

    private static Map<String, List<URL>> REGISTER = new HashMap<String, List<URL>>();

    public static void register(String interfaceName, URL url) {
        List<URL> list = REGISTER.get(interfaceName);
        if (list == null) {
            list = new ArrayList<URL>();
        }
        list.add(url);
        REGISTER.put(interfaceName, list);
    }

    public static List<URL> get(String interfaceName) {
        List<URL> list = REGISTER.get(interfaceName);
        return list;
    }

}
