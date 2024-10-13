package tech.microservice.webflux_design_patterns.client;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class ApplicationConfig {

  private static final String PRODUCT_BASE_URL = "http://localhost:3000";

  @Bean
  public WebClient getWebClient () {

    return WebClient.builder ().baseUrl (PRODUCT_BASE_URL).build ();

  }
}
