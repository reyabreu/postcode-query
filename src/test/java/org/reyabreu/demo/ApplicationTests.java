package org.reyabreu.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.reyabreu.demo.config.ApplicationConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

  Logger logger = LoggerFactory.getLogger(this.getClass());

  @Autowired
  ApplicationConfiguration config;

	@Test
	public void contextLoads() {
    logger.info("validate: {}", config.getGatewayProperties().getUri().get("validate"));
	}

}
