package com.caixabanktech.arq.twittergateway.infrastructure.http.backend.services.tweets.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class GetTweetsResponse {

    @JsonProperty
    private List<TweetResponse> tweets;
}
