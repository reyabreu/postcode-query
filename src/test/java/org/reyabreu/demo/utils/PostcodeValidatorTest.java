package org.reyabreu.demo.utils;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.reyabreu.demo.services.PostcodesService;

@RunWith(MockitoJUnitRunner.class)
public class PostcodeValidatorTest {

  private static final String REGEX =
      "^([Gg][Ii][Rr]\\s*0[Aa]{2})|((([A-Za-z][0-9]{1,2})|(([A-Za-z][A-Ha-hJ-Yj-y][0-9]{1,2})|"
          + "(([A-Za-z][0-9][A-Za-z])|([A-Za-z][A-Ha-hJ-Yj-y][0-9]?[A-Za-z]))))\\s*[0-9][A-Za-z]{2})$";

  @Mock
  private PostcodesService serviceMock;

  private PostcodeValidator postcodeValidator;

  @Rule
  public ExpectedException exception = ExpectedException.none();

  @Before
  public void setUp() {
    postcodeValidator = new PostcodeValidator(serviceMock, REGEX);
  }

  @Test
  public void validate_validPostCodes_ok() {
    when(serviceMock.isValid(anyString())).thenReturn(true);

    postcodeValidator.validate("PE276HU");
    postcodeValidator.validate("PE27 6HU");
    verify(serviceMock, Mockito.times(2)).isValid(anyString());
  }

  @Test
  public void validate_invalidPostCodes_fail() {
    exception.expect(IllegalArgumentException.class);

    postcodeValidator.validate("alpha");
    postcodeValidator.validate("PAAA6HU");
  }

}
