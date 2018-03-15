package org.reyabreu.demo.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Objects;

/**
 * This is the domain object that will be used in the business layer.
 * 
 * @author reynaldoabreu
 *
 */
public class PostcodeDetails {

  private final String country;
  private final String region;

  public PostcodeDetails(String country, String region) {
    super();
    this.country = country;
    this.region = region;
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
    return Objects.equals(country, other.country) && Objects.equals(region, other.region);
  }

  public String getCountry() {
    return country;
  }

  public String getRegion() {
    return region;
  }

  @Override
  public int hashCode() {
    return Objects.hash(country, region);
  }

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
  }

}
