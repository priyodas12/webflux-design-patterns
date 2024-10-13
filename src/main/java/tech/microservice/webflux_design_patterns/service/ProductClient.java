package tech.microservice.webflux_design_patterns.service;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;
import tech.microservice.webflux_design_patterns.model.Product;
import tech.microservice.webflux_design_patterns.model.ProductResponse;

@Service
public class ProductClient {

  @Autowired
  private WebClient webClient;

  public Mono<Product> getProductResponseByProductId (BigInteger productId) {

    String PRODUCT_URI = "/products/" + productId;

    return webClient.get ()

        .uri (PRODUCT_URI)
        .retrieve ()
        .bodyToMono (ProductResponse.class)
        .map (ProductResponse::getProduct);
  }
}
