package org.reyabreu.demo;

import org.reyabreu.demo.gateway.config.GatewayProperties;
import org.reyabreu.demo.services.PostcodesRestClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class ApplicationRunner implements CommandLineRunner {

  private static final Logger logger = LoggerFactory.getLogger(ApplicationRunner.class);

  @Autowired
  GatewayProperties gatewayProperties;

  @Autowired
  PostcodesRestClient client;

  String getUri(final String key) {
    final Map<String, String> uriMap = gatewayProperties.getUri();
    return uriMap.get(key);
  }

  @Override
  public void run(String... args) throws Exception {
    logger.info("validate uri: {}", getUri("validate"));
    logger.info("{}", client.lookup("PE276HU"));
  }

}
