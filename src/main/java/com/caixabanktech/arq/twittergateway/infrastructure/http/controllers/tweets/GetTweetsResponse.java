package com.caixabanktech.arq.twittergateway.infrastructure.http.controllers.tweets;

import com.caixabanktech.arq.twittergateway.domain.entities.Tweet;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class GetTweetsResponse {

    @JsonProperty
    private List<Tweet> tweets;
}
