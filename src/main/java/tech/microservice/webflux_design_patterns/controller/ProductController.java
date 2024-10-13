package tech.microservice.webflux_design_patterns.controller;


import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;
import tech.microservice.webflux_design_patterns.model.Product;
import tech.microservice.webflux_design_patterns.service.ProductClient;

@RequestMapping ("/api/v1")
@RestController
public class ProductController {

  @Autowired
  private ProductClient productService;

  @GetMapping ("/products/{productId}")
  public Mono<Product> getProductResponse (@PathVariable ("productId") BigInteger productId) {
    return productService.getProductResponseByProductId (productId);
  }
}
