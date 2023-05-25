package com.caixabanktech.arq.twittergateway.infrastructure.http.backend.services.tweets.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UpdateTweetRequest {

    @JsonProperty
    private String id;

    @JsonProperty
    private String text;
}
