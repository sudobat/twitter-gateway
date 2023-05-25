package com.caixabanktech.arq.twittergateway.application.services.likes;

import com.caixabanktech.arq.twittergateway.domain.services.LikeService;
import org.springframework.stereotype.Service;

@Service
public class DeleteLikesOfTweet {

    private final LikeService likeService;

    public DeleteLikesOfTweet(LikeService likeService) {
        this.likeService = likeService;
    }

    public void execute(String tweetId) {
        likeService.deleteLikesOfTweet(tweetId);
    }
}
