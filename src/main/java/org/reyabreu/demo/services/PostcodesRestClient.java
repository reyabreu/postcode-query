package org.reyabreu.demo.services;

import org.reyabreu.demo.web.PostcodesResponseResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class PostcodesRestClient {

  @Value("${api.postcodes.uri.lookup}")
  private String lookupUrl;

  @Value("${api.postcodes.uri.validate}")
  private String validateUrl;

  @Value("${api.postcodes.uri.nearest}")
  private String nearestUrl;

  @Autowired
  RestTemplate restTemplate;

  public PostcodesResponseResource lookup(final String postcode) {
    return restTemplate.getForObject(String.format(lookupUrl, postcode),
        PostcodesResponseResource.class);
  }

  public PostcodesResponseResource validate(final String postcode) {
    return restTemplate.getForObject(String.format(validateUrl, postcode),
        PostcodesResponseResource.class);
  }

  public PostcodesResponseResource nearestPostcodes(final String postcode) {
    return restTemplate.getForObject(String.format(nearestUrl, postcode),
        PostcodesResponseResource.class);
  }
}
