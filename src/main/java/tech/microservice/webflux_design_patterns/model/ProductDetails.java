package tech.microservice.webflux_design_patterns.model;

import java.util.List;

import lombok.Data;

@Data
public class ProductDetails {

  private Product product;
  private List<Review> reviewList;
  private List<Promotion> promotionList;

}
