package org.reyabreu.demo;

import org.reyabreu.demo.exceptions.FatalCommandLineException;
import org.reyabreu.demo.utils.ArgumentsValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("prod")
public class ApplicationRunner implements CommandLineRunner {

  private static final Logger logger = LoggerFactory.getLogger(ApplicationRunner.class);

  @Autowired
  private ArgumentsValidator validator;

  @Override
  public void run(String... args) throws Exception {
    try {
      validator.validate(args);
      logger.info("hello World!");
    } catch (IllegalArgumentException ex) {
      throw new FatalCommandLineException("Invalid program input", ex);
    }
  }

}
