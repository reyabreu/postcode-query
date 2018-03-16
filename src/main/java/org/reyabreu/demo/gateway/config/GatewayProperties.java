package org.reyabreu.demo.gateway.config;

import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * The RestTemplateBuilder is automatically injected by Spring. We can use it to
 * create a RestTemplate and benefit from all the autoconfiguration that happens
 * in Spring Boot with message converters and request factories. The
 * RestTemplate is exposed as a @Bean to make it easier to test and mock.
 * 
 * @author Reynaldo
 *
 */
@ConfigurationProperties(prefix = "api.postcodes")
public class GatewayProperties {

  private String baseUri;
  private Map<String, String> paths;

  public String getBaseUri() {
    return baseUri;
  }

  public void setBaseUri(String baseUri) {
    this.baseUri = baseUri;
  }

  public Map<String, String> getPaths() {
    return paths;
  }

  public void setPaths(Map<String, String> paths) {
    this.paths = paths;
  }

  @Bean
  public RestTemplate restTemplate(RestTemplateBuilder builder) {
    return builder.build();
  }

}
