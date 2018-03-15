package org.reyabreu.demo.utils;

import org.reyabreu.demo.exceptions.InvalidInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ArgumentsValidator {

  @Autowired
  private PostcodeValidator postcodeValidator;

  public void validate(String... args) {
    if (args.length != 1) {
      throw new InvalidInputException("Please supply a single valid postcode as argument");
    }
    final String postcode = args[0];
    postcodeValidator.validate(postcode);
  }

}
