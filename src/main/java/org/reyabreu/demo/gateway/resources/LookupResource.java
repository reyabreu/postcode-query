package org.reyabreu.demo.gateway.resources;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LookupResource extends PostcodesResource {

  @JsonProperty
  private LookupResultResource result;

  public LookupResource() {
  }

  public LookupResultResource getResult() {
    return result;
  }

  public void setResult(LookupResultResource result) {
    this.result = result;
  }

}
