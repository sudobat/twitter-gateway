package com.caixabanktech.arq.twittergateway.infrastructure.http.controllers;

import com.caixabanktech.arq.twittergateway.application.services.likes.CreateLike;
import com.caixabanktech.arq.twittergateway.application.services.likes.DeleteLike;
import com.caixabanktech.arq.twittergateway.application.services.likes.DeleteLikesOfTweet;
import com.caixabanktech.arq.twittergateway.application.services.tweets.CreateTweet;
import com.caixabanktech.arq.twittergateway.application.services.tweets.DeleteTweet;
import com.caixabanktech.arq.twittergateway.application.services.tweets.GetTweets;
import com.caixabanktech.arq.twittergateway.application.services.tweets.UpdateTweet;
import com.caixabanktech.arq.twittergateway.domain.entities.Tweet;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/likes")
public class LikesController {

    private final CreateLike createLike;
    private final DeleteLike deleteLike;
    private final DeleteLikesOfTweet deleteLikesOfTweet;

    public LikesController(
            CreateLike createLike,
            DeleteLike deleteLike,
            DeleteLikesOfTweet deleteLikesOfTweet) {

        this.createLike = createLike;
        this.deleteLike = deleteLike;
        this.deleteLikesOfTweet = deleteLikesOfTweet;
    }

    @PostMapping("")
    public String createLike(String tweetId, String authorId) {
        createLike.execute(tweetId, authorId);
        return "OK";
    }

    @PostMapping("unlike")
    public String deleteLike(String tweetId, String authorId) {
        deleteLike.execute(tweetId, authorId);
        return "OK";
    }

    @DeleteMapping("{tweetId}/likes")
    public String deleteLikesOfTweet(@PathVariable String tweetId) {
        deleteLikesOfTweet.execute(tweetId);
        return "OK";
    }
}
