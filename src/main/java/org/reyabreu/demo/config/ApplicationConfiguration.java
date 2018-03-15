package org.reyabreu.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * The RestTemplateBuilder is automatically injected by Spring. We can use it to create a
 * RestTemplate and benefit from all the autoconfiguration that happens in Spring Boot with message
 * converters and request factories. The RestTemplate is exposed as a @Bean to make it easier to
 * test and mock.
 * 
 * @author reynaldoabreu
 *
 */
@Configuration
@EnableConfigurationProperties({GatewayProperties.class})
public class ApplicationConfiguration {

  @Autowired
  private GatewayProperties gatewayProperties;

  public GatewayProperties getGatewayProperties() {
    return gatewayProperties;
  }

  @Bean
  public RestTemplate restTemplate(RestTemplateBuilder builder) {
    return builder.build();
  }

}
