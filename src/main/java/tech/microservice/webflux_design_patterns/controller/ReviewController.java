package tech.microservice.webflux_design_patterns.controller;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;
import tech.microservice.webflux_design_patterns.model.Review;
import tech.microservice.webflux_design_patterns.service.ReviewClient;

@RequestMapping ("/api/v1")
@RestController
public class ReviewController {

  @Autowired
  private ReviewClient reviewClient;

  @GetMapping ("/reviews/product/{productId}")
  public Mono<List<Review>> getReviewResponse (@PathVariable ("productId") BigInteger productId) {
    return reviewClient
        .getReviewResponseByProductId (productId)
        .map (val -> {
          List<Review> reviewList = new ArrayList<> ();
          if (!val.getReviewList ().isEmpty ()) {
            System.out.println ("Promotion list not empty!");
            for (Review rev : val.getReviewList ()) {
              System.out.println (rev.getReviewId ());
              reviewList.add (rev);
            }
          }
          return reviewList;
        });
  }
}

