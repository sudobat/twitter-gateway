package com.caixabanktech.arq.twittergateway.infrastructure.http.backend.services.likes.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CountLikesOfTweetResponse {

    @JsonProperty
    private Long countLikes;
}
