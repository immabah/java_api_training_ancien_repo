package fr.lernejo.navy_battle;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;

public class HttpPostHandler implements HttpHandler {
    public final int port;
    public final String url;
    public HttpPostHandler(int port, String url){
        this.port = port;
        this.url = url;
    }

    public void handle(HttpExchange httpExchange) throws IOException {
        if (httpExchange.getRequestMethod().equals("POST")) {
            Response(httpExchange, "Ok");
        } else {
            httpExchange.sendResponseHeaders(404, -1);
        }
        httpExchange.close();
    }
    public void Response(HttpExchange httpExchange, String body) throws IOException{
        String msg = "{\"id\":\"1\", \"url\":\"http://localhost:" + this.port + "\", \"message\":\"hello\"}";
        httpExchange.getResponseHeaders().set("Content-type", "application/json");
        httpExchange.sendResponseHeaders(202, body.length());
        try (OutputStream os = httpExchange.getResponseBody()){
            os.write(msg.getBytes());
        }

    }
}


