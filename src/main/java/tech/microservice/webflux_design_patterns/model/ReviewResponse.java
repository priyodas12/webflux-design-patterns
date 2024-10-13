package tech.microservice.webflux_design_patterns.model;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReviewResponse {

  private String message;
  private List<Review> reviewList;
}
