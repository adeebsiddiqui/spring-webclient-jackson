package com.ad.springwebclientjackson.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class ReqResWebClientConfig {

    @Value("${api.req-res.url}")
    private String reqResApiUrl;

    @Bean
    public WebClient reqResWeblient() {
        return WebClient.builder()
                .baseUrl(reqResApiUrl)
                .build();
    }
}
