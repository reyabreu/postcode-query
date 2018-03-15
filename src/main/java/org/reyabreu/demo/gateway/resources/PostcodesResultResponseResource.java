package org.reyabreu.demo.gateway.resources;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class PostcodesResultResponseResource {

  private String country;
  private String region;

  @JsonCreator
  public PostcodesResultResponseResource(@JsonProperty(required = true) String country,
      @JsonProperty(required = false) String region) {
    super();
    this.country = country;
    this.region = region;
  }

  public String getCountry() {
    return country;
  }

  public String getRegion() {
    return region;
  }

}
