package com.caixabanktech.arq.twittergateway.application.services.tweets;

import com.caixabanktech.arq.twittergateway.domain.services.TweetService;
import org.springframework.stereotype.Service;

@Service
public class CreateTweet {

    private final TweetService tweetService;

    public CreateTweet(TweetService tweetService) {
        this.tweetService = tweetService;
    }

    public String execute(String text, String authorId) {
        String id = tweetService.createTweet(text, authorId);
        return id;
    }
}
