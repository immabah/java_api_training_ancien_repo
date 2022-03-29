package fr.lernejo.navy_battle;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;

public class HttpPostHandler implements HttpHandler {
    public final int port;
    public HttpPostHandler(int port){
        this.port = port;
    }

    public void handle(HttpExchange httpExchange) throws IOException {
        if (httpExchange.getRequestMethod().equals("POST")) {
            Response(httpExchange);
        } else {
            httpExchange.sendResponseHeaders(404, -1);
        }
    }
    public void Response(HttpExchange httpExchange) throws IOException{
        String msg = "{\"id\":\"1\"," + this.port + "\", \"url\":\"http://localhost:" + this.port + "\", \"message\":\"Cool\"}";
        httpExchange.getResponseHeaders().set("Content-type", "application/json");
        httpExchange.sendResponseHeaders(202, msg.length());
        try (OutputStream os = httpExchange.getResponseBody()){
            os.write(msg.getBytes());
        }
        System.out.println("Connected");

    }
}


