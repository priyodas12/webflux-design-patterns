package tech.microservice.webflux_design_patterns.service;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;
import tech.microservice.webflux_design_patterns.model.ReviewResponse;

@Service
public class ReviewClient {

  @Autowired
  private WebClient webClient;

  public Mono<ReviewResponse> getReviewResponseByProductId (BigInteger productId) {

    String REVIEW_URI = "/reviews/product/" + productId;

    return webClient.get ()

        .uri (REVIEW_URI)
        .retrieve ()
        .bodyToMono (ReviewResponse.class);
  }
}
