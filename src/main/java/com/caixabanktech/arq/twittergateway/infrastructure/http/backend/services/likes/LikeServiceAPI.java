package com.caixabanktech.arq.twittergateway.infrastructure.http.backend.services.likes;

import com.caixabanktech.arq.twittergateway.domain.services.LikeService;
import com.caixabanktech.arq.twittergateway.infrastructure.http.backend.services.BaseServiceAPI;
import com.caixabanktech.arq.twittergateway.infrastructure.http.backend.services.likes.requests.CreateLikeRequest;
import com.caixabanktech.arq.twittergateway.infrastructure.http.backend.services.likes.responses.CountLikesOfTweetResponse;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
public class LikeServiceAPI extends BaseServiceAPI implements LikeService {

    public LikeServiceAPI(@Qualifier("LikeService") WebClient webClient) {
        super(webClient);
    }

    @Override
    public Long countLikesOfTweet(String tweetId) {
        CountLikesOfTweetResponse response = webClient
                .get()
                .uri("/likes/" + tweetId + "/count")
                .retrieve()
                .bodyToMono(CountLikesOfTweetResponse.class)
                .timeout(Duration.ofSeconds(5))
                .block();

        if (response == null) {
            return 0L;
        }

        return response.getCountLikes();
    }

    @Override
    public void createLike(String tweetId, String authorId) {

        CreateLikeRequest request = new CreateLikeRequest(tweetId, authorId);

        webClient
                .post()
                .uri("/tweets")
                .body(Mono.just(request), CreateLikeRequest.class)
                .retrieve()
                .bodyToMono(Void.class)
                .timeout(Duration.ofSeconds(5))
                .block();
    }

    @Override
    public void deleteLike(String tweetId, String authorId) {

        webClient
                .delete()
                .uri("/likes")
                .retrieve()
                .bodyToMono(Void.class)
                .timeout(Duration.ofSeconds(5))
                .block();
    }

    @Override
    public void deleteLikesOfTweet(String tweetId) {

        webClient
                .delete()
                .uri("/tweets/" + tweetId + "/likes")
                .retrieve()
                .bodyToMono(Void.class)
                .timeout(Duration.ofSeconds(5))
                .block();
    }
}
