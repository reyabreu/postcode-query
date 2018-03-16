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

      System.out.println("\n\tPostcode details:");
      System.out.println("\t-----------------");
      System.out.println("\t  Postcode: " + details.getPostcode());
      System.out.println("\t   Country: " + details.getCountry());
      System.out.println("\t    Region: " + details.getRegion());

      System.out.println("\n\tNearest Postcode(s):");
      System.out.println("\t---------------------");
      service.findNearestPostcodes(postcode).stream().forEach(x -> {
        System.out.println("\t  Postcode: " + x.getPostcode());
        System.out.println("\t   Country: " + x.getCountry());
        System.out.println("\t    Region: " + x.getRegion());
        System.out.println();
      });

    } catch (IllegalArgumentException ex) {
      throw new FatalCommandLineException("Invalid program input", ex);
    }
  }

}
