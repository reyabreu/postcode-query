package org.reyabreu.demo.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class PostcodeDetails {

	private String country;
	private String region;

	public PostcodeDetails(String country, String region) {
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

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

}
