package com.caixabanktech.arq.twittergateway.repositories;

import com.caixabanktech.arq.twittergateway.entities.Tweet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TweetRepository extends JpaRepository<Tweet, String> {
}
