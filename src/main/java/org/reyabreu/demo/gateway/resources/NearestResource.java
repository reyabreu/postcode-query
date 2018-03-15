package org.reyabreu.demo.gateway.resources;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class NearestResource extends PostcodesResource {

  @JsonProperty
  private List<LookupResultResource> result;

  public NearestResource() {
  }

  public List<LookupResultResource> getResult() {
    return result;
  }

  public void setResult(List<LookupResultResource> result) {
    this.result = result;
  }

}
