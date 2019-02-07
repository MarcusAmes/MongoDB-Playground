package com.example.MongoDBplayground;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@RestController
@RequestMapping("/route")
public class RouteController {

    @PostMapping("/get")
    public Route getRoute(@RequestParam String iAddress, @RequestParam String bAddress) throws IOException {
        URL url = new URL("https://maps.googleapis.com/maps/api/directions/json?origin=" + iAddress + "&destination=" + bAddress + "&key=");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        int status = con.getResponseCode();

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        con.disconnect();

        System.out.println(content.toString());

        return new Route();
    }

    @GetMapping("/test")
    public TestUser routeTest() throws IOException {
        URL url = new URL("https://jsonplaceholder.typicode.com/todos/1");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        int status = con.getResponseCode();

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        con.disconnect();

        System.out.println(content.toString());
        TestUser testUser = new ObjectMapper().readValue(content.toString(), TestUser.class);

        return testUser;
    }
}
