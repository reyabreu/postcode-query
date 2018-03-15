package org.reyabreu.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;

@ConfigurationProperties(prefix = "api.postcodes")
public class GatewayProperties {

  private Map<String, String> uri;

  public Map<String, String> getUri() {
    return uri;
  }

  public void setUri(Map<String, String> uri) {
    this.uri = uri;
  }

}
