package com.caixabanktech.arq.twittergateway.application.services.tweets;

import com.caixabanktech.arq.twittergateway.domain.services.TweetService;
import org.springframework.stereotype.Service;

@Service
public class UpdateTweet {

    private final TweetService tweetService;

    public UpdateTweet(TweetService tweetService) {
        this.tweetService = tweetService;
    }

    public void execute(String id, String text) {
        tweetService.updateTweet(id, text);
    }
}
