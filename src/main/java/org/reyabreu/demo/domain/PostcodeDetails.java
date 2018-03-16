package org.reyabreu.demo.domain;

import java.util.Objects;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * This is the domain object that will be used in the business layer.
 * 
 * @author reynaldoabreu
 *
 */
public class PostcodeDetails {

  public static class Builder {

    String postcode;
    String country;
    String region;

    public PostcodeDetails build() {
      return new PostcodeDetails(this);
    }

    public Builder country(String country) {
      this.country = country;
      return this;
    }

    public Builder postcode(String postcode) {
      this.postcode = postcode;
      return this;
    }

    public Builder region(String region) {
      this.region = region;
      return this;
    }

  }

  public static Builder builder() {
    return new PostcodeDetails.Builder();
  }

  private final String postcode;
  private final String country;
  private final String region;

  public PostcodeDetails(Builder builder) {
    super();
    this.postcode = builder.postcode;
    this.country = builder.country;
    this.region = builder.region;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final PostcodeDetails other = (PostcodeDetails) obj;
    return Objects.equals(postcode, other.postcode) && Objects.equals(country, other.country)
        && Objects.equals(region, other.region);
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

  @Override
  public int hashCode() {
    return Objects.hash(postcode, country, region);
  }

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
  }

}
