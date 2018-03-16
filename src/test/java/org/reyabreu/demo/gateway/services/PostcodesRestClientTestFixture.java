package org.reyabreu.demo.gateway.services;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.reyabreu.demo.gateway.resources.LookupResource;
import org.reyabreu.demo.gateway.resources.LookupResultResource;
import org.reyabreu.demo.gateway.resources.NearestResource;
import org.reyabreu.demo.gateway.resources.ValidateResource;

public class PostcodesRestClientTestFixture {

  public static LookupResource createLookupResource() {
    LookupResource responseResource = new LookupResource();
    responseResource.setResult(createLookupResultResource());
    responseResource.setStatus(200);
    return responseResource;
  }

  public static LookupResultResource createLookupResultResource() {
    LookupResultResource result = new LookupResultResource();
    result.setPostcode("postcode");
    result.setCountry("country");
    result.setRegion("region");
    return result;
  }

  public static NearestResource createNearestResponse() {
    NearestResource responseResource = new NearestResource();
    responseResource.setStatus(200);
    responseResource.setResult(Stream.of(createLookupResultResource()).collect(Collectors.toList()));
    return responseResource;
  }

  public static ValidateResource createValidateResource() {
    ValidateResource responseResource = new ValidateResource();
    responseResource.setStatus(200);
    responseResource.setResult(true);
    return responseResource;
  }

}