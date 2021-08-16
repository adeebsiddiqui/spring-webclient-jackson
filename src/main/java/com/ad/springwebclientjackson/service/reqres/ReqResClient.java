package com.ad.springwebclientjackson.service.reqres;

import com.ad.springwebclientjackson.model.reqres.User;
import io.github.resilience4j.decorators.Decorators;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class ReqResClient {

    private final WebClient reqResWebClient;
    private final ReqResResiliencyService reqResResiliencyService;

    public ReqResClient(WebClient reqResWebClient, ReqResResiliencyService reqResResiliencyService) {
        this.reqResWebClient = reqResWebClient;
        this.reqResResiliencyService = reqResResiliencyService;
    }

    public User sendRequest(String userId) {
        ResponseEntity<User> response;

        try {
            response = Decorators.ofSupplier(() -> callService(userId))
                    .withCircuitBreaker(reqResResiliencyService.getCircuitBreaker())
                    .withRetry(reqResResiliencyService.getRetryContext())
                    .get();
        } catch (Exception e) {
            throw e;
        }

        return response.getBody();
    }

    private ResponseEntity<User> callService(String userId) {
        return reqResWebClient.get()
                .uri("/users/{userId}", userId)
                .retrieve()
                .bodyToMono(User.class)
                .map(ResponseEntity::ok)
                .block();
    }
}
