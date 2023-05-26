package com.caixabanktech.arq.twittergateway.infrastructure.http.backend.services.tweets;

import com.caixabanktech.arq.twittergateway.domain.entities.Tweet;
import com.caixabanktech.arq.twittergateway.domain.services.TweetService;
import com.caixabanktech.arq.twittergateway.infrastructure.http.backend.services.BaseServiceAPI;
import com.caixabanktech.arq.twittergateway.infrastructure.http.backend.services.tweets.requests.CreateTweetRequest;
import com.caixabanktech.arq.twittergateway.infrastructure.http.backend.services.tweets.requests.UpdateTweetRequest;
import com.caixabanktech.arq.twittergateway.infrastructure.http.backend.services.tweets.responses.CreateTweetResponse;
import com.caixabanktech.arq.twittergateway.infrastructure.http.backend.services.tweets.responses.GetTweetsResponse;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@Service
public class TweetServiceAPI extends BaseServiceAPI implements TweetService {

    public TweetServiceAPI(@Qualifier("TweetService") WebClient webClient) {
        super(webClient);
    }

    @Override
    public List<Tweet> getTweets(int page) {
        GetTweetsResponse getTweetsResponse = webClient
                .get()
                .uri("/tweets?page=" + page)
                .retrieve()
                .bodyToMono(GetTweetsResponse.class)
                .timeout(Duration.ofSeconds(5))
                .block();

        if (getTweetsResponse == null) {
            return new ArrayList<>();
        }

        return getTweetsResponse.getTweets().stream()
                .map(tweetResponse -> new Tweet(
                        tweetResponse.getId(),
                        tweetResponse.getAuthor(),
                        tweetResponse.getDesc(),
                        tweetResponse.getCreatedAt(),
                        0L))
                .toList();
    }

    @Override
    public String createTweet(String text, String authorId) {

        CreateTweetRequest request = new CreateTweetRequest(authorId, text);

        CreateTweetResponse createTweetResponse = webClient
                .post()
                .uri("/tweets")
                .body(Mono.just(request), CreateTweetRequest.class)
                .retrieve()
                .bodyToMono(CreateTweetResponse.class)
                .timeout(Duration.ofSeconds(5))
                .block();

        if (createTweetResponse == null) {
            return null;
        }

        return createTweetResponse.getTweetId();
    }

    @Override
    public void updateTweet(String id, String text) {

        UpdateTweetRequest request = new UpdateTweetRequest(text);

        webClient
                .put()
                .uri("/tweets/" + id)
                .body(Mono.just(request), UpdateTweetRequest.class)
                .retrieve()
                .bodyToMono(Void.class)
                .timeout(Duration.ofSeconds(5))
                .block();
    }

    @Override
    public void deleteTweet(String id) {

        webClient
                .delete()
                .uri("/tweets/" + id)
                .retrieve()
                .bodyToMono(Void.class)
                .timeout(Duration.ofSeconds(5))
                .block();
    }
}
