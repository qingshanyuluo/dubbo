package xyz.lennon.dubbo.framework;

import xyz.lennon.dubbo.protocol.http.HttpProtocal;

public class ProtocolFactory {

    public static Protocol getProtocol() {
        String name = System.getProperty("protocolName");
        if (name == null || name.equals("")) name = "http";
        switch (name) {
            case "http":
                return new HttpProtocal();
            case "dubbo":
                throw new RuntimeException("not yet completed");
            default:
                return new HttpProtocal();
        }
//        throw  new RuntimeException("no protocol specified");
    }


}
