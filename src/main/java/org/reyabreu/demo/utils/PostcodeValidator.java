package org.reyabreu.demo.utils;

import org.reyabreu.demo.services.PostcodesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
public class PostcodeValidator {

  private final Pattern pattern;

  @Autowired
  private PostcodesService postcodesService;

  public PostcodeValidator(@Value("${regex}") String regex) {
    super();
    this.pattern = Pattern.compile(regex);
  }

  public void validate(final String postcode) {
    if (!(pattern.matcher(postcode).matches() && postcodesService.isValid(postcode))) {
      throw new IllegalArgumentException(String.format("'%s' is an invalid postcode.", postcode));
    }
  }

}
