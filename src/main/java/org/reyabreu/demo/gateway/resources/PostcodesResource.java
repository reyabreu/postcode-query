package org.reyabreu.demo.gateway.resources;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public abstract class PostcodesResource {

  @JsonProperty(required = true)
  private Integer status;

  @JsonProperty
  private String error;

  public String getError() {
    return error;
  }

  public Integer getStatus() {
    return status;
  }

  public void setError(String error) {
    this.error = error;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }
}
