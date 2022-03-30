package fr.lernejo.navy_battle;

import org.junit.Test;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import java.io.IOException;

class PingTest {
    @Test
    public void test1() {
        public void Pingtest()  {
            HttpResponse<String> msg = null;
            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:9876/ping"))
                .setHeader("Accept", "application/json")
                .build();
            try {
                response = HttpClient.newHttpClient().send(requestGet, HttpResponse.BodyHandlers.ofString());
            }
            catch (Exception e) {
                System.err.println(" Ping error " + e);
            }
            Assertions.assertEquals( 200, msg.statusCode() );
            Assertions.assertEquals( "OK", msg.body() );
        }

    }
}

