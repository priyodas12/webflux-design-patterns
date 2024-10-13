package tech.microservice.webflux_design_patterns.model;

import java.math.BigInteger;
import java.util.Date;
import java.util.UUID;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Promotion {

  private BigInteger promotionId;
  private UUID promotionUUID;
  private BigInteger productId;
  private String promotionDetails;
  private Date promotionStartTimestamp;
  private Date promotionEndTimestamp;
  private String promotionType;
  private Integer discountPercentage;
}
