package com.caixabanktech.arq.twittergateway.domain.services;

public interface LikeService {

    Long countLikesOfTweet(String tweetId);

    void createLike(String tweetId, String authorId);

    void deleteLike(String tweetId, String authorId);

    void deleteLikesOfTweet(String tweetId);
}
