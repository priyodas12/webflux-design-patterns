package tech.microservice.webflux_design_patterns.controller;


import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;
import tech.microservice.webflux_design_patterns.model.ProductDetails;
import tech.microservice.webflux_design_patterns.service.ProductDetailsService;


@RequestMapping ("/api/v1")
@RestController
public class ProductDetailsController {

  @Autowired
  private ProductDetailsService productDetailsService;

  @GetMapping ("/products/details/{productId}")
  public Mono<ProductDetails> getProductDetails (@PathVariable ("productId") BigInteger productId) {
    return productDetailsService.getProductDetails (productId);
  }
}
