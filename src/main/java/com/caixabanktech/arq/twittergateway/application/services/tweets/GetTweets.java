package com.caixabanktech.arq.twittergateway.application.services.tweets;

import com.caixabanktech.arq.twittergateway.domain.entities.Tweet;
import com.caixabanktech.arq.twittergateway.domain.services.LikeService;
import com.caixabanktech.arq.twittergateway.domain.services.TweetService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetTweets {

    private final TweetService tweetService;
    private final LikeService likeService;

    public GetTweets(TweetService tweetService, LikeService likeService) {
        this.tweetService = tweetService;
        this.likeService = likeService;
    }

    public List<Tweet> execute(int page) {
        List<Tweet> tweets = tweetService.getTweets(page);

        tweets.forEach(tweet -> {
            Long likes = likeService.countLikesOfTweet(tweet.getId());
            tweet.setLikes(likes);
        });

        return tweets;
    }
}
