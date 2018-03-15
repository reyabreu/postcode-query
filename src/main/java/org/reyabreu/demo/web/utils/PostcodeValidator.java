package org.reyabreu.demo.web.utils;

import org.apache.commons.lang3.StringUtils;
import org.reyabreu.demo.exceptions.InvalidInputException;
import org.springframework.stereotype.Component;

@Component
public class PostcodeValidator {

	public void validate(final String postcode) {
    if (StringUtils.isBlank(postcode)) {
      throw new InvalidInputException("postcode cannot be empty");
    }
	}

}
