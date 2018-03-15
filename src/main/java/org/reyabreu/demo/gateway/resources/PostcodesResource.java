package org.reyabreu.demo.gateway.resources;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class PostcodesResource {

  @JsonProperty(required = true)
  private String status;

  @JsonProperty
  private String error;

  public PostcodesResource() {
  }

  public String getError() {
    return error;
  }

  public String getStatus() {
    return status;
  }

  public void setError(String error) {
    this.error = error;
  }

  public void setStatus(String status) {
    this.status = status;
  }
}
