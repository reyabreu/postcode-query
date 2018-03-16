package org.reyabreu.demo.config;

import org.reyabreu.demo.gateway.config.GatewayProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 
 * @author reynaldoabreu
 *
 */
@Configuration
@ConfigurationProperties
@EnableConfigurationProperties({ GatewayProperties.class })
public class ApplicationConfiguration {

  @Autowired
  private GatewayProperties gatewayProperties;

  private String regex;

  public String getRegex() {
    return regex;
  }

  public void setRegex(String regex) {
    this.regex = regex;
  }

  public GatewayProperties getGatewayProperties() {
    return gatewayProperties;
  }

}
