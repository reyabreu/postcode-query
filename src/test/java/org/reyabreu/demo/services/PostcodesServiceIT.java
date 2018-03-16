package org.reyabreu.demo.services;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

  private static final String TEST_POSTCODE = "PE27 6HU";
  private static final String TEST_COUNTRY = "England";
  private static final String TEST_REGION = "East of England";

  static class Fixture {

    public static PostcodeDetails postcodeDetails() {
      return PostcodeDetails.builder().postcode(TEST_POSTCODE).country(TEST_COUNTRY).region(TEST_REGION).build();
    }

    public static List<PostcodeDetails> postcodeDetailsList() {
      return Stream.of(postcodeDetails()).collect(Collectors.toList());
    }

  }

  @Autowired
  private PostcodesService service;

  @Test
  public void getDetails_validPostCode_returnsData() {
    final PostcodeDetails expected = Fixture.postcodeDetails();
    assertThat(service.getDetails(TEST_POSTCODE), is(expected));
  }

  @Test
  public void getNearestPostcodes_validPostCode_returnsData() {
    final List<PostcodeDetails> expected = Fixture.postcodeDetailsList();
    assertThat(service.findNearestPostcodes(TEST_POSTCODE), is(expected));
  }

  @Test
  public void validate_invalidPostCode_returnsFalse() {
    assertFalse(service.isValid("PAAA1KL"));
  }

  @Test
  public void validate_validPostCode_returnsTrue() {
    assertTrue(service.isValid(TEST_POSTCODE));
  }

}
