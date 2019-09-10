package xyz.lennon.dubbo.protocol.http;

import xyz.lennon.dubbo.framework.Invocation;
import xyz.lennon.dubbo.framework.Protocol;
import xyz.lennon.dubbo.framework.URL;

public class HttpProtocal implements Protocol {
    @Override
    public void start(URL url) {
        new HttpServer().start(url.getHostname(), url.getPort());
    }

    @Override
    public String send(URL url, Invocation invocation) {
        return new HttpClient().send(url.getHostname(), url.getPort(), invocation);
    }
}
