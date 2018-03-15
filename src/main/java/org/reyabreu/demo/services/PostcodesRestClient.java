package org.reyabreu.demo.services;

import org.reyabreu.demo.gateway.config.GatewayProperties;
import org.reyabreu.demo.gateway.resources.PostcodesResponseResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Component
public class PostcodesRestClient {

  @Autowired
  private GatewayProperties gatewayProperties;

  @Autowired
  private RestTemplate restTemplate;

  private String getUri(final String key) {
    final Map<String, String> uriMap = gatewayProperties.getUri();
    return uriMap.get(key);
  }

  public PostcodesResponseResource lookup(final String postcode) {
    return restTemplate.getForObject(String.format(getUri("lookup"), postcode),
        PostcodesResponseResource.class);
  }

  public PostcodesResponseResource validate(final String postcode) {
    return restTemplate.getForObject(String.format(getUri("validate"), postcode),
        PostcodesResponseResource.class);
  }

  public PostcodesResponseResource nearestPostcodes(final String postcode) {
    return restTemplate.getForObject(String.format(getUri("nearest"), postcode),
        PostcodesResponseResource.class);
  }
}
