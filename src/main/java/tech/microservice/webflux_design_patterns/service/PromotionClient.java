package tech.microservice.webflux_design_patterns.service;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;
import tech.microservice.webflux_design_patterns.model.PromotionResponse;

@Service
public class PromotionClient {

  @Autowired
  private WebClient webClient;

  public Mono<PromotionResponse> getPromotionResponseByProductId (BigInteger productId) {

    String PROMOTION_URI = "/promotions/product/" + productId;

    return webClient.get ()

        .uri (PROMOTION_URI)
        .retrieve ()
        .bodyToMono (PromotionResponse.class);
  }
}
