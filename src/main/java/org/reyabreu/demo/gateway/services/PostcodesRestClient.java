package org.reyabreu.demo.gateway.services;

import java.util.Arrays;
import java.util.Map;

import org.reyabreu.demo.gateway.config.GatewayProperties;
import org.reyabreu.demo.gateway.resources.LookupResource;
import org.reyabreu.demo.gateway.resources.NearestResource;
import org.reyabreu.demo.gateway.resources.PostcodesResource;
import org.reyabreu.demo.gateway.resources.ValidateResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

@Component
public class PostcodesRestClient {

  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  private final GatewayProperties gatewayProperties;
  private final RestTemplate restTemplate;

  @Autowired
  public PostcodesRestClient(RestTemplate restTemplate, GatewayProperties gatewayProperties) {
    super();
    this.restTemplate = restTemplate;
    this.gatewayProperties = gatewayProperties;
  }

  private String getUri(final String key) {
    final Map<String, String> pathsMap = gatewayProperties.getPaths();
    return gatewayProperties.getBaseUri() + pathsMap.get(key);
  }

  protected <T extends PostcodesResource> T get(String path, String postcode, Class<T> resourceType) {
    HttpHeaders headers = new HttpHeaders();
    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON_UTF8));

    HttpEntity<String> requestEntity = new HttpEntity<String>(headers);

    logger.debug("GET request on: {} with argument: {}", path, postcode);

    ResponseEntity<T> response;
    try {
      response = restTemplate.exchange(path, HttpMethod.GET, requestEntity, resourceType, postcode);
    } catch (ResourceAccessException ex) {
      throw new RuntimeException("Remote resource is inaccesible.", ex);
    }

    final T resource = response.getBody();
    if (response.getStatusCodeValue() > 200) {
      throw new RuntimeException(
          String.format("Request failed with code %d: %s", resource.getStatus(), resource.getError()));
    }
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
