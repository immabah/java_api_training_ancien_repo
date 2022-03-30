package fr.lernejo.navy_battle;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class HttpPostHandler implements HttpHandler {
    public final int port;
    public final String url;
    public HttpPostHandler(int port, String url){
        this.port = port;
        this.url = url;
    }

    public void handle(HttpExchange httpExchange) throws IOException {
        if (httpExchange.getRequestMethod().equals("POST")) {
            Response(httpExchange);
        } else {
            httpExchange.sendResponseHeaders(404, -1);
        }
    }
    public void Response(HttpExchange httpExchange) throws IOException{
        String msg = "{\"id\":\"1\", \"url\":\"http://localhost:" + this.port + "\", \"message\":\"hello\"}";
        String recev = new String(httpExchange.getRequestBody().readAllBytes(), StandardCharsets.UTF_8);
        System.out.println(recev);
        httpExchange.getResponseHeaders().set("Content-type", "application/json");
        httpExchange.sendResponseHeaders(202, msg.length());
        try (OutputStream os = httpExchange.getResponseBody()){
            os.write(msg.getBytes());
        }

    }
}


