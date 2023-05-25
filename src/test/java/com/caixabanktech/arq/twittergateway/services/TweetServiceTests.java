package com.caixabanktech.arq.twittergateway.services;

import com.caixabanktech.arq.twittergateway.entities.Tweet;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class TweetServiceTests {

    @Autowired
    private TweetService tweetService;

    @Test
    public void it_returns_the_list_of_tweets_we_previously_added_with_1_element() {

        String id = tweetService.addTweet("Hola");
        List<Tweet> tweets = tweetService.getTweets();

        List<Tweet> expected = new ArrayList<>() {{ add(new Tweet(id, "Hola")); }};

        assertEquals(expected, tweets);
    }

    @Test
    public void it_returns_the_list_of_tweets_we_previously_added_with_many_elements() {

        String id = tweetService.addTweet("Hola");
        String id2 = tweetService.addTweet("Adeu");

        List<Tweet> tweets = tweetService.getTweets();

        List<Tweet> expected = new ArrayList<>() {{
            add(new Tweet(id, "Hola"));
            add(new Tweet(id2, "Adeu"));
        }};

        assertEquals(expected, tweets);
    }

    @Test
    public void it_updates_a_tweet_with_a_specific_id() {

        String id = tweetService.addTweet("Hola");

        tweetService.updateTweet(id, "Adeu");

        List<Tweet> tweets = tweetService.getTweets();

        List<Tweet> expected = new ArrayList<>() {{
            add(new Tweet(id, "Adeu"));
        }};

        assertEquals(expected, tweets);
    }
}
