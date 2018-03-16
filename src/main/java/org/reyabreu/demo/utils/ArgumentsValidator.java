package org.reyabreu.demo.utils;

import org.springframework.stereotype.Component;

@Component
public class ArgumentsValidator {

  public void validate(String... args) {
    if (args.length == 0) {
      throw new IllegalArgumentException("no argument supplied.");
    }
    if (args.length > 1) {
      throw new IllegalArgumentException("too many arguments.");
    }
  }

}
