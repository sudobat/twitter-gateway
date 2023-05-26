package com.caixabanktech.arq.twittergateway.infrastructure.http.backend.services.tweets.responses;

import com.caixabanktech.arq.twittergateway.domain.entities.Tweet;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class TweetResponse {

    @JsonProperty
    private String id;

    @JsonProperty
    private String author;

    @JsonProperty
    private String desc;

    @JsonProperty
    private Date createdAt;
}
