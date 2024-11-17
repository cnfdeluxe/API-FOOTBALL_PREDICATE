
package com.example.football.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "apiFootballClient", url = "${api.football.url}")
public interface ApiFootballClient {

    @GetMapping("/fixtures")
    String getFixtures(@RequestHeader("x-rapidapi-key") String apiKey,
                       @RequestHeader("x-rapidapi-host") String host);
}
