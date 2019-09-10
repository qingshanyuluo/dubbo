package xyz.lennon.dubbo.provider;

import xyz.lennon.dubbo.framework.Protocol;
import xyz.lennon.dubbo.framework.ProtocolFactory;
import xyz.lennon.dubbo.framework.URL;
import xyz.lennon.dubbo.protocol.http.HttpProtocal;
import xyz.lennon.dubbo.protocol.http.HttpServer;
import xyz.lennon.dubbo.provider.api.HelloService;
import xyz.lennon.dubbo.provider.impl.HelloServiceImpl;
import xyz.lennon.dubbo.register.RemoteMapRegister;

public class Provider {

    public static void main(String[] args) {

        //1. local register {interface: impl}
        LocalRegister.register(HelloService.class.getName(), HelloServiceImpl.class);

        //2. register center register {interfaceName: List<URL>}
        URL url = new URL("localhost", 8080);
        RemoteMapRegister.register(HelloService.class.getName(), url);

        //3. start server
//        HttpServer httpServer = new HttpServer();
//        httpServer.start("localhost", 8080);

        //4. use protocol
        Protocol protocol = ProtocolFactory.getProtocol();
        protocol.start(url);
    }
}
