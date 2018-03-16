package org.reyabreu.demo;

import org.reyabreu.demo.domain.PostcodeDetails;
import org.reyabreu.demo.exceptions.FatalCommandLineException;
import org.reyabreu.demo.services.PostcodesService;
import org.reyabreu.demo.utils.ArgumentsValidator;
import org.reyabreu.demo.utils.PostcodeValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("prod")
public class ApplicationRunner implements CommandLineRunner {

  // private final Logger logger =
  // LoggerFactory.getLogger(ApplicationRunner.class);

  @Autowired
  private ArgumentsValidator argumentsValidator;

  @Autowired
  private PostcodeValidator postcodeValidator;

  @Autowired
  private PostcodesService service;

  @Override
  public void run(String... args) throws Exception {
    try {
      argumentsValidator.validate(args);
      String postcode = args[0];

      postcodeValidator.validate(postcode);
      PostcodeDetails details = service.getDetails(postcode);

      System.out.println("\nPostcode details:");
      System.out.println("  Postcode: " + details.getPostcode());
      System.out.println("   Country: " + details.getCountry());
      System.out.println("    Region: " + details.getRegion());

    } catch (IllegalArgumentException ex) {
      throw new FatalCommandLineException("Invalid program input", ex);
    }
  }

}
