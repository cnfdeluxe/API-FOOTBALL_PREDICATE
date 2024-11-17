
package com.example.football.controller;

import com.example.football.client.ApiFootballClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FootballController {

    private final ApiFootballClient apiFootballClient;

    @Value("${api.football.key}")
    private String apiKey;

    public FootballController(ApiFootballClient apiFootballClient) {
        this.apiFootballClient = apiFootballClient;
    }

    @GetMapping("/fixtures")
    public String getFixtures() {
        return apiFootballClient.getFixtures(apiKey, "v3.football.api-sports.io");
    }
}
