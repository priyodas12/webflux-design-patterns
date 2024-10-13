package tech.microservice.webflux_design_patterns.model;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Price {

  private BigDecimal latestPrice;
  private int discount;
  private BigDecimal discountedPrice;
  private BigDecimal amountSaved;

}
