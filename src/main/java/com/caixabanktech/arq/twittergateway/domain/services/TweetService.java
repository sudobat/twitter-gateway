package com.caixabanktech.arq.twittergateway.domain.services;

import com.caixabanktech.arq.twittergateway.domain.entities.Tweet;

import java.util.List;

public interface TweetService {

    List<Tweet> getTweets(int page);

    String createTweet(String text, String authorId);

    void updateTweet(String id, String text);

    void deleteTweet(String id);
}
