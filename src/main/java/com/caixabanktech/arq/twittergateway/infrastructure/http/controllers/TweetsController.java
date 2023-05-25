package com.caixabanktech.arq.twittergateway.infrastructure.http.controllers;

import com.caixabanktech.arq.twittergateway.application.services.tweets.CreateTweet;
import com.caixabanktech.arq.twittergateway.application.services.tweets.DeleteTweet;
import com.caixabanktech.arq.twittergateway.application.services.tweets.GetTweets;
import com.caixabanktech.arq.twittergateway.application.services.tweets.UpdateTweet;
import com.caixabanktech.arq.twittergateway.domain.entities.Tweet;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tweets")
public class TweetsController {

    private final CreateTweet createTweet;
    private final UpdateTweet updateTweet;
    private final DeleteTweet deleteTweet;
    private final GetTweets getTweets;

    public TweetsController(
            CreateTweet createTweet,
            UpdateTweet updateTweet,
            DeleteTweet deleteTweet,
            GetTweets getTweets) {

        this.createTweet = createTweet;
        this.updateTweet = updateTweet;
        this.deleteTweet = deleteTweet;
        this.getTweets = getTweets;
    }

    @GetMapping("")
    public List<Tweet> getTweets(int page) {
        return getTweets.execute(page);
    }

    @PostMapping("")
    public String createTweet(String text, String authorId) {
        return createTweet.execute(text, authorId);
    }

    @PutMapping("{tweetId}")
    public String updateTweet(@PathVariable String tweetId, String text) {
        updateTweet.execute(tweetId, text);
        return "OK";
    }

    @DeleteMapping("{tweetId}")
    public String deleteTweet(@PathVariable String tweetId) {
        deleteTweet.execute(tweetId);
        return "OK";
    }
}
