package org.reyabreu.demo.utils;

import java.util.regex.Pattern;

import org.reyabreu.demo.services.PostcodesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PostcodeValidator {

  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  private final Pattern pattern;
  private final PostcodesService postcodesService;

  @Autowired
  public PostcodeValidator(PostcodesService postcodesService, @Value("${regex}") String regex) {
    super();
    this.postcodesService = postcodesService;
    this.pattern = Pattern.compile(regex);
  }

  public void validate(final String postcode) {
    if (!(pattern.matcher(postcode).matches() && postcodesService.isValid(postcode))) {
      throw new IllegalArgumentException(String.format("'%s' is an invalid postcode.", postcode));
    }
    logger.debug("postcode '{}' is valid.", postcode);
  }

}
