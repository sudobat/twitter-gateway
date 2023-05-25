package com.caixabanktech.arq.twittergateway.infrastructure.http.backend.services;

import org.springframework.web.reactive.function.client.WebClient;

public abstract class BaseServiceAPI {

    protected WebClient webClient;

    public BaseServiceAPI(WebClient webClient) {
        this.webClient = webClient;
    }
}
