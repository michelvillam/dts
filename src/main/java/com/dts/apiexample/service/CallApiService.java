package com.dts.apiexample.service;

import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class CallApiService {

    static Logger logger = Logger.getLogger(CallApiService.class.getName());
    private static final String URL = "https://postman-echo.com/get?foo1=bar1&foo2=bar2";

    public String CallApi(){

        logger.info("Calling URL: " + URL);
        HttpClient httpClient = HttpClient.newHttpClient();

        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(URL))
                .GET()
                .build();
        try {
            HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            logger.info("Call api succesfully with body: " + response.body());
            return response.body();

        }catch (Exception e){
            String message = String.format("Error getting url: {} ", URL);
            logger.log(Level.WARNING, message);
        }

        return "";
    }
}
