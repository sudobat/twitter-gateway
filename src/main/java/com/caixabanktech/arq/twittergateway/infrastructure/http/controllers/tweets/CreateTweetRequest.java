package com.caixabanktech.arq.twittergateway.infrastructure.http.controllers.tweets;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateTweetRequest {

    @JsonProperty
    @Size(max = 250)
    @NotBlank
    private String text;

    @JsonProperty
    @NotBlank
    private String authorId;
}
