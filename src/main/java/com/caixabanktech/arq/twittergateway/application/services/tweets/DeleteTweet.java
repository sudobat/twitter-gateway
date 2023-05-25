package com.caixabanktech.arq.twittergateway.application.services.tweets;

import com.caixabanktech.arq.twittergateway.domain.services.LikeService;
import com.caixabanktech.arq.twittergateway.domain.services.TweetService;
import org.springframework.stereotype.Service;

@Service
public class DeleteTweet {

    private final TweetService tweetService;
    private final LikeService likeService;

    public DeleteTweet(TweetService tweetService, LikeService likeService) {
        this.tweetService = tweetService;
        this.likeService = likeService;
    }

    public void execute(String id) {
        tweetService.deleteTweet(id);
        likeService.deleteLikesOfTweet(id);
    }
}
