package org.reyabreu.demo.utils;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class PostcodeValidatorIT {

  @Autowired
  private PostcodeValidator postcodeValidator;

  @Rule
  public ExpectedException exception = ExpectedException.none();

  @Test
  public void validate_validPostCodes_ok() {
    postcodeValidator.validate("PE276HU");
    postcodeValidator.validate("PE27 6HU");
  }

  @Test
  public void validate_invalidPostCodes_fail() {
    exception.expect(IllegalArgumentException.class);

    postcodeValidator.validate("alpha");
    postcodeValidator.validate("PAAA6HU");
  }

}
