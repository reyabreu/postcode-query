package org.reyabreu.demo.gateway.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;

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

}
