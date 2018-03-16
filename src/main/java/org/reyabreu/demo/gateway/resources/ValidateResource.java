package org.reyabreu.demo.gateway.resources;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ValidateResource extends PostcodesResource {

  @JsonProperty
  private Boolean result;

  public ValidateResource() {
  }

  public Boolean getResult() {
    return result;
  }

  public void setResult(Boolean result) {
    this.result = result;
  }

}
