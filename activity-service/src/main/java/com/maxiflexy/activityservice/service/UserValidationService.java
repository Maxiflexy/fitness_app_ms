package com.maxiflexy.activityservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Service
@RequiredArgsConstructor
public class UserValidationService {

    private final WebClient userServiceWebclient;

    public boolean validateUser(String userId){

        try {
            return Boolean.TRUE.equals(userServiceWebclient.get()
                    .uri("/api/users/{userId}/validate", userId)
                    .retrieve()
                    .bodyToMono(Boolean.class)
                    .block());
        }catch (WebClientResponseException e){
            if(e.getStatusCode() == NOT_FOUND)
                throw new RuntimeException("User not found: " + userId);
            else if(e.getStatusCode() == BAD_REQUEST)
                throw new RuntimeException("Invalid Request: " + userId);
        }
        return false;
    }
}
