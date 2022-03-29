package fr.lernejo.navy_battle;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpClient_navy {
    private final HttpClient client;
    public final int port;

    public HttpClient_navy(int port) {
        this.client = HttpClient.newHttpClient();
        this.port = port;

    }

    public void SendStart(String url) throws IOException, InterruptedException {
        HttpRequest requestPost = HttpRequest.newBuilder()
            .uri(URI.create(url + "/api/game/start"))
            .setHeader("Accept", "application/json")
            .setHeader("Content-Type", "application/json")
            .POST(HttpRequest.BodyPublishers.ofString("{\"id\":\"1\", \"url\":\"http://localhost:" + this.port + "\", \"message\":\"hello\"}"))            .build();

        HttpClient cl = HttpClient.newHttpClient();
        var clr = cl.send(requestPost, HttpResponse.BodyHandlers.ofString());
        System.out.println(clr.statusCode());
        System.out.println(clr.body());

    }
}
