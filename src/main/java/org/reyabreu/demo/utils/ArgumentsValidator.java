package org.reyabreu.demo.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ArgumentsValidator {

  @Autowired
  private PostcodeValidator postcodeValidator;

  public void validate(String... args) {
    if (args.length == 0) {
      throw new IllegalArgumentException("no argument supplied.");
    }
    if (args.length > 1) {
      throw new IllegalArgumentException("too many arguments.");
    }
    String postcode = args[0];
    postcodeValidator.validate(postcode);
  }

}
