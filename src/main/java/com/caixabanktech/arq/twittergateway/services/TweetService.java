package com.caixabanktech.arq.twittergateway.services;

import com.caixabanktech.arq.twittergateway.entities.Tweet;
import com.caixabanktech.arq.twittergateway.repositories.TweetRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TweetService {

    private final TweetRepository tweetRepository;

    public TweetService(TweetRepository tweetRepository) {
        this.tweetRepository = tweetRepository;
    }

    public List<Tweet> getTweets() {
        return tweetRepository.findAll();
    }

    public String addTweet(String text) {
        String id = String.valueOf(UUID.randomUUID());
        tweetRepository.save(new Tweet(id, text));
        return id;
    }

    public void updateTweet(String id, String text) {
        tweetRepository.save(new Tweet(id, text));
    }
}
