package tech.microservice.webflux_design_patterns.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.UUID;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductResponse {

  private String message;
  private Product product;
}
