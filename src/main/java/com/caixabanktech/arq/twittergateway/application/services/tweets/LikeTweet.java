package com.caixabanktech.arq.twittergateway.application.services.tweets;

import com.caixabanktech.arq.twittergateway.domain.services.LikeService;
import org.springframework.stereotype.Service;

@Service
public class LikeTweet {

    private final LikeService likeService;

    public LikeTweet(LikeService likeService) {
        this.likeService = likeService;
    }

    public void execute(String tweetId, String authorId) {
        likeService.createLike(tweetId, authorId);
    }
}
