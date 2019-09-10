package xyz.lennon.dubbo.consumer;

import xyz.lennon.dubbo.framework.Invocation;
import xyz.lennon.dubbo.framework.ProxyFactory;
import xyz.lennon.dubbo.protocol.http.HttpClient;
import xyz.lennon.dubbo.provider.api.HelloService;

public class Consumer {

    public static void main(String[] args) {
        HelloService helloService = ProxyFactory.getProxy(HelloService.class);

        System.out.println(helloService.sayHello("zzzzzz"));
    }
}
