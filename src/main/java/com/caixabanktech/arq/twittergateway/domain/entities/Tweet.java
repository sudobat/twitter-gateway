package com.caixabanktech.arq.twittergateway.domain.entities;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tweet {

    private String id;

    @NotBlank(message = "Author is mandatory")
    private String author;

    @NotBlank(message = "Text is mandatory")
    @Size(max = 250)
    private String text;

    private Date createdAt;

    @PositiveOrZero
    private Long likes;
}
