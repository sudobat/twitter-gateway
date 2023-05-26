package com.caixabanktech.arq.twittergateway.infrastructure.http.controllers;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateLikeRequest {

    @JsonProperty
    @NotBlank
    private String tweetId;

    @JsonProperty
    @NotBlank
    private String authorId;
}
