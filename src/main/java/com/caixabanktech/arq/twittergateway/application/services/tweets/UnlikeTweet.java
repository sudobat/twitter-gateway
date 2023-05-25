package com.caixabanktech.arq.twittergateway.application.services.tweets;

import com.caixabanktech.arq.twittergateway.domain.services.LikeService;
import org.springframework.stereotype.Service;

@Service
public class UnlikeTweet {

    private final LikeService likeService;

    public UnlikeTweet(LikeService likeService) {
        this.likeService = likeService;
    }

    public void execute(String tweetId, String authorId) {
        likeService.deleteLike(tweetId, authorId);
    }
}
