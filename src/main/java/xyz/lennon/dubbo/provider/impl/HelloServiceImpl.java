package xyz.lennon.dubbo.provider.impl;

import xyz.lennon.dubbo.provider.api.HelloService;

public class HelloServiceImpl implements HelloService {
    public String sayHello(String userName) {
        return "Hello " + userName;
    }
}
