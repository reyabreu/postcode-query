package org.reyabreu.demo.services;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.reyabreu.demo.domain.PostcodeDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class PostcodesServiceIT {

  // Logger logger = LoggerFactory.getLogger(this.getClass());

  @Autowired
  private PostcodesService service;

  @Test
  public void getDetails_validPostCode_returnsData() {
    final PostcodeDetails expected = new PostcodeDetails("England", "East of England");
    assertThat(service.getDetails("PE27 6HU"), is(expected));
  }

  @Test
  public void validate_validPostCode_returnsTrue() {
    assertTrue(service.isValid("PE27 6HU"));
  }

  @Test
  public void validate_invalidPostCode_returnsFalse() {
    assertFalse(service.isValid("PAAA1KL"));
  }

  @Test
  public void getNearst_validPostCode_returnsData() {

  }

}
