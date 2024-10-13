package tech.microservice.webflux_design_patterns.service;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Mono;
import tech.microservice.webflux_design_patterns.model.ProductDetails;

@Service
public class ProductDetailsService {

  @Autowired
  private ProductClient productClient;

  @Autowired
  private ReviewClient reviewClient;

  @Autowired
  private PromotionClient promotionClient;

  public Mono<ProductDetails> getProductDetails (BigInteger productId) {

    var productResponse = productClient.getProductResponseByProductId (productId);

    var reviewResponse = reviewClient.getReviewResponseByProductId (productId);

    var promotionResponse = promotionClient.getPromotionResponseByProductId (productId);

    return productResponse.flatMap (productResult -> {
      return reviewResponse.flatMap (reviewResult -> {
        return promotionResponse.flatMap (promotionResult -> {

          ProductDetails productDetails = new ProductDetails ();
          productDetails.setProduct (productResult);
          productDetails.setReviewList (reviewResult.getReviewList ());
          productDetails.setPromotionList (promotionResult.getPromotionList ());

          return Mono.just (productDetails);
        });
      });
    });

  }
}
