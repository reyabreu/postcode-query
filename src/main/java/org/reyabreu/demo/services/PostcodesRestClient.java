package org.reyabreu.demo.services;

import org.reyabreu.demo.gateway.config.GatewayProperties;
import org.reyabreu.demo.gateway.resources.LookupResource;
import org.reyabreu.demo.gateway.resources.NearestResource;
import org.reyabreu.demo.gateway.resources.ValidateResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Map;

@Component
public class PostcodesRestClient {

  @Autowired
  private GatewayProperties gatewayProperties;

  @Autowired
  private RestTemplate restTemplate;

  private String getUri(final String key) {
    final Map<String, String> pathsMap = gatewayProperties.getPaths();
    return gatewayProperties.getBaseUri() + pathsMap.get(key);
  }

  protected <T> T get(String path, String postcode, Class<T> resourceType) {
    HttpHeaders headers = new HttpHeaders();
    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON_UTF8));

    HttpEntity<String> requestEntity = new HttpEntity<String>(headers);

    ResponseEntity<T> response =
        restTemplate.exchange(path, HttpMethod.GET, requestEntity, resourceType, postcode);

    final T resource = response.getBody();
    return resource;
  }

  public LookupResource lookup(final String postcode) {
    return get(getUri("lookup"), postcode, LookupResource.class);
  }

  public ValidateResource validate(final String postcode) {
    return get(getUri("validate"), postcode, ValidateResource.class);
  }

  public NearestResource nearestPostcodes(final String postcode) {
    return get(getUri("nearest"), postcode, NearestResource.class);
  }

}
