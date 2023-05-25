package com.caixabanktech.arq.twittergateway.infrastructure.http.backend.services.likes.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateLikeRequest {

    @JsonProperty
    private String tweetId;

    @JsonProperty
    private String author;
}
