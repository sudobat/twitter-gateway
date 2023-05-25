package com.caixabanktech.arq.twittergateway.infrastructure.http.backend;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfiguration {
    @Bean
    @Qualifier("TweetService")
    public WebClient tweetServiceWebClient(WebClient.Builder webClientBuilder) {
        return webClientBuilder
                .baseUrl("TWEET_SERVICE_URL")
                .build();
    }

    @Bean
    @Qualifier("LikeService")
    public WebClient likeServiceWebClient(WebClient.Builder webClientBuilder) {
        return webClientBuilder
                .baseUrl("LIKE_SERVICE_URL")
                .build();
    }
}
