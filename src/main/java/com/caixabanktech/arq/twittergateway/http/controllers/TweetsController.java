package com.caixabanktech.arq.twittergateway.http.controllers;

import com.caixabanktech.arq.twittergateway.entities.Tweet;
import com.caixabanktech.arq.twittergateway.services.TweetService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tweets")
public class TweetsController {

    private final TweetService tweetService;

    public TweetsController(TweetService tweetService) {
        this.tweetService = tweetService;
    }

    @GetMapping("")
    public List<Tweet> getTweets() {
        return tweetService.getTweets();
    }

    @PostMapping("")
    public String createTweet(String text) {
        return tweetService.addTweet(text);
    }

    @PutMapping("{tweetId}")
    public String updateTweet(String text) {
        return "OK";
    }

    @DeleteMapping("{tweetId}")
    public String deleteTweet() {
        return "OK";
    }
}
