package tech.microservice.webflux_design_patterns.model;


import java.math.BigInteger;
import java.util.Date;
import java.util.UUID;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Review {

  private BigInteger reviewId;
  private UUID reviewUUID;
  private BigInteger productId;
  private String reviewDetails;
  private Date reviewCreateTimestamp;
  private Integer reviewRating;
  private String reviewCountry;
  private Date reviewUpdateTimestamp;
}
