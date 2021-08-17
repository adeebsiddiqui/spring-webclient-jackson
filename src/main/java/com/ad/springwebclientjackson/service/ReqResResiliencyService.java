package com.ad.springwebclientjackson.service;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import io.github.resilience4j.retry.Retry;
import io.github.resilience4j.retry.RetryConfig;
import io.github.resilience4j.retry.RetryRegistry;
import lombok.AccessLevel;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
public class ReqResResiliencyService {
    private static final int MAX_ATTEMPTS = 3;
    private static final int FIFTY = 50;

    @Getter(AccessLevel.PACKAGE)
    private final CircuitBreaker circuitBreaker;

    @Getter(AccessLevel.PACKAGE)
    private final Retry retryContext;

    public ReqResResiliencyService(CircuitBreakerRegistry circuitBreakerRegistry) {
        RetryConfig retryConfig = RetryConfig.custom()
                .maxAttempts(MAX_ATTEMPTS)
                .waitDuration(Duration.ofMillis(FIFTY))
                .build();

        RetryRegistry retryRegistry = RetryRegistry.of(retryConfig);

        circuitBreaker = circuitBreakerRegistry.circuitBreaker("ReqResService");
        retryContext = retryRegistry.retry("ReqResService");
    }
}
