package xyz.lennon.dubbo.framework;

import xyz.lennon.dubbo.protocol.http.HttpClient;
import xyz.lennon.dubbo.provider.api.HelloService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory<T> {

    public static <T> T getProxy(Class interfaceClass) {
        return (T) Proxy.newProxyInstance(interfaceClass.getClassLoader(), new Class[]{interfaceClass}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                HttpClient httpClient = new HttpClient();
                Invocation invocation = new Invocation(HelloService.class.getName()
                        , method.getName()
                        , new Class[]{String.class}
                        , args);
                String result = httpClient.send("localhost", 8080, invocation);
                return result;
            }
        });
    }
}
