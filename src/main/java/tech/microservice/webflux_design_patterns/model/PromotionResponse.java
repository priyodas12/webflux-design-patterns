package tech.microservice.webflux_design_patterns.model;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PromotionResponse {

  private String message;
  private List<Promotion> promotionList;

}
