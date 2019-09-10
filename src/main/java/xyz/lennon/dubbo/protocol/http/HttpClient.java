package xyz.lennon.dubbo.protocol.http;

import com.alibaba.fastjson.JSONObject;
import xyz.lennon.dubbo.framework.Invocation;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpClient {

    public String send(String hostname, Integer port, Invocation invocation) {

        try {
            var request = HttpRequest.newBuilder()
                    .uri(new URI("http", null, hostname, port, "/", null, null))
                    .POST(HttpRequest.BodyPublishers.ofString(JSONObject.toJSONString(invocation)))
                    .build();
            var client = java.net.http.HttpClient.newHttpClient();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            String result = response.body();
            return result;
        } catch (URISyntaxException | InterruptedException | IOException e) {
            e.printStackTrace();
        }

        return null;

    }
}
