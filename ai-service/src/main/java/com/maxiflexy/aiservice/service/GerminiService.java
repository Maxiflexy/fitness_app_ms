package com.maxiflexy.aiservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;

@Service
public class GerminiService {

    private final WebClient webClient;

    @Value("${germini.api.url}")
    private String germiniApiUrl;

    @Value("${germini.api.key}")
    private String germiniApiKey;

    public GerminiService(WebClient.Builder webClientBuilder) {
        this.webClient = WebClient.builder().build();
    }

    public String getAnswer(String question){
        Map<String, Object> requestBody = Map.of(
                "contents", new Object[]{
                        Map.of("parts", new Object[]{
                                Map.of("text", question)
                        })
                }
        );

        String response = webClient.post()
                .uri(germiniApiUrl + germiniApiKey)
                .header("Content-Type", "application/json")
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono(String.class)
                .block();

        return response;
    }
}
