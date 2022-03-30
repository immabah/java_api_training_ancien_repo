package fr.lernejo.navy_battle;

import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;


import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

class HttpPingHandlerTest {

    @Test
    public void test1() {

            HttpResponse<String> msg = null;
            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:9876/ping"))
                .setHeader("Accept", "application/json")
                .build();
            try {
                msg = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            }
            catch (Exception e) {
                System.err.println(" Ping error " + e);
            }
            Assertions.assertEquals( 200, msg.statusCode() );
            Assertions.assertEquals( "OK", msg.body() );
        }

    }



