package com.caixabanktech.arq.twittergateway.infrastructure.http.backend.services.tweets.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateTweetRequest {

    @JsonProperty
    private String authorId;

    @JsonProperty
    private String text;
}
