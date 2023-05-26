package com.caixabanktech.arq.twittergateway.infrastructure.http.backend;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfiguration {

    @Value("${backend.hosts.tweets-service:localhost}")
    private String tweetsServiceHost;

    @Value("${backend.hosts.likes-service:localhost}")
    private String likesServiceHost;

    @Bean
    @Qualifier("TweetService")
    public WebClient tweetServiceWebClient(WebClient.Builder webClientBuilder) {
        return webClientBuilder
                .baseUrl(tweetsServiceHost)
                .build();
    }

    @Bean
    @Qualifier("LikeService")
    public WebClient likeServiceWebClient(WebClient.Builder webClientBuilder) {
        return webClientBuilder
                .baseUrl(likesServiceHost)
                .build();
    }
}
