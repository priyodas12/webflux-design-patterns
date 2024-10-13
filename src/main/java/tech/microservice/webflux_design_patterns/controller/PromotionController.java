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
import tech.microservice.webflux_design_patterns.model.Promotion;
import tech.microservice.webflux_design_patterns.service.PromotionClient;

@RequestMapping ("/api/v1")
@RestController
public class PromotionController {

  @Autowired
  private PromotionClient promotionClient;

  @GetMapping ("/promotions/product/{productId}")
  public Mono<List<Promotion>> getPromotionResponse (
      @PathVariable ("productId") BigInteger productId
                                                    ) {
    return promotionClient
        .getPromotionResponseByProductId (productId)
        .map (val -> {
          List<Promotion> promotionList = new ArrayList<> ();
          if (!val.getPromotionList ().isEmpty ()) {
            System.out.println ("Promotion list not empty!");
            for (Promotion promo : val.getPromotionList ()) {
              System.out.println (promo.getPromotionId ());
              promotionList.add (promo);
            }
          }
          return promotionList;
        });
  }
}
