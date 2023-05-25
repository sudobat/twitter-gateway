package com.caixabanktech.arq.twittergateway.application.services.likes;

import com.caixabanktech.arq.twittergateway.domain.services.LikeService;
import org.springframework.stereotype.Service;

@Service
public class CreateLike {

    private final LikeService likeService;

    public CreateLike(LikeService likeService) {
        this.likeService = likeService;
    }

    public void execute(String tweetId, String authorId) {
        likeService.createLike(tweetId, authorId);
    }
}
