package org.reyabreu.demo.gateway.services;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.reyabreu.demo.gateway.config.GatewayProperties;
import org.reyabreu.demo.gateway.resources.LookupResource;
import org.reyabreu.demo.gateway.resources.NearestResource;
import org.reyabreu.demo.gateway.resources.ValidateResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class PostcodesRestClientTest {

  @Mock
  GatewayProperties gatewayPropertiesMock;

  @Mock
  RestTemplate restTemplateMock;

  @InjectMocks
  PostcodesRestClient postcodesRestClient;

  @Test
  public void nearest_postcode_getDetails() {
    ResponseEntity<NearestResource> response = new ResponseEntity<>(
        PostcodesRestClientTestFixture.createNearestResponse(), HttpStatus.OK);
    when(restTemplateMock.exchange(anyString(), eq(HttpMethod.GET), ArgumentMatchers.<HttpEntity<String>>any(),
        eq(NearestResource.class), anyString())).thenReturn(response);

    NearestResource actual = postcodesRestClient.nearestPostcodes("postcode");

    assertThat(actual.getStatus(), is(200));
    assertThat(actual.getResult().size(), is(1));
    assertThat(actual.getResult().get(0).getPostcode(), is("postcode"));
    assertThat(actual.getResult().get(0).getRegion(), is("region"));
    assertThat(actual.getResult().get(0).getCountry(), is("country"));
  }

  @Test
  public void lookup_postcode_getDetails() {
    ResponseEntity<LookupResource> response = new ResponseEntity<>(
        PostcodesRestClientTestFixture.createLookupResource(), HttpStatus.OK);
    when(restTemplateMock.exchange(anyString(), eq(HttpMethod.GET), ArgumentMatchers.<HttpEntity<String>>any(),
        eq(LookupResource.class), anyString())).thenReturn(response);

    LookupResource actual = postcodesRestClient.lookup("postcode");

    assertThat(actual.getStatus(), is(200));
    assertThat(actual.getResult().getPostcode(), is("postcode"));
    assertThat(actual.getResult().getRegion(), is("region"));
    assertThat(actual.getResult().getCountry(), is("country"));
  }

  @Before
  public void setUp() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void validate_postcode_ok() {
    ResponseEntity<ValidateResource> responseResource = new ResponseEntity<>(
        PostcodesRestClientTestFixture.createValidateResource(), HttpStatus.OK);
    when(restTemplateMock.exchange(anyString(), eq(HttpMethod.GET), ArgumentMatchers.<HttpEntity<String>>any(),
        eq(ValidateResource.class), anyString())).thenReturn(responseResource);

    ValidateResource actual = postcodesRestClient.validate("postcode");

    assertThat(actual.getStatus(), is(200));
    assertThat(actual.getResult(), is(true));
  }

}
