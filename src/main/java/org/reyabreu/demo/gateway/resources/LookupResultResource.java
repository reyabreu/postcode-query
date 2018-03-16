package org.reyabreu.demo.gateway.resources;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LookupResultResource {

  @JsonProperty(required = true)
  private String postcode;

  @JsonProperty(required = true)
  private String country;

  @JsonProperty(required = false)
  private String region;

  public LookupResultResource() {
  }

  public String getCountry() {
    return country;
  }

  public String getPostcode() {
    return postcode;
  }

  public String getRegion() {
    return region;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public void setPostcode(String postcode) {
    this.postcode = postcode;
  }

  public void setRegion(String region) {
    this.region = region;
  }

}
