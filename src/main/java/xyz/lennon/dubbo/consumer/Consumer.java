package xyz.lennon.dubbo.consumer;

import xyz.lennon.dubbo.framework.Invocation;
import xyz.lennon.dubbo.protocol.http.HttpClient;
import xyz.lennon.dubbo.provider.api.HelloService;

public class Consumer {

    public static void main(String[] args) {

        HttpClient httpClient = new HttpClient();
        Invocation invocation = new Invocation(HelloService.class.getName()
                , "sayHello"
                , new Class[]{String.class}
                , new Object[]{"minbao"});
        String result = httpClient.send("localhost", 8080, invocation);
        System.out.println(result);
    }
}
