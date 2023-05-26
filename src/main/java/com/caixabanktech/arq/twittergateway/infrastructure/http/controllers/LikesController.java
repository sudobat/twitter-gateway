package com.caixabanktech.arq.twittergateway.infrastructure.http.controllers;

import com.caixabanktech.arq.twittergateway.application.services.likes.CreateLike;
import com.caixabanktech.arq.twittergateway.application.services.likes.DeleteLike;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/likes")
public class LikesController {

    private final CreateLike createLike;
    private final DeleteLike deleteLike;

    public LikesController(
            CreateLike createLike,
            DeleteLike deleteLike) {

        this.createLike = createLike;
        this.deleteLike = deleteLike;
    }

    @PostMapping("")
    public String createLike(@RequestBody CreateLikeRequest createLikeRequest) {
        createLike.execute(
                createLikeRequest.getTweetId(),
                createLikeRequest.getAuthorId());
        return "OK";
    }

    @PostMapping("unlike")
    public String deleteLike(@RequestBody CreateLikeRequest createLikeRequest) {
        deleteLike.execute(
                createLikeRequest.getTweetId(),
                createLikeRequest.getAuthorId());
        return "OK";
    }
}
