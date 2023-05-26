package com.caixabanktech.arq.twittergateway.infrastructure.http.controllers.tweets;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateTweetRequest {

    @JsonProperty
    @Size(max = 250)
    @NotBlank
    private String text;
}
