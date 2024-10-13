package tech.microservice.webflux_design_patterns.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.UUID;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Product {

  private BigInteger productId;
  private UUID productUUID;
  private String productName;
  private String productDesc;
  private String productCreateDate;
  private boolean isAvailableNow;
  private BigDecimal productPrice;
}
