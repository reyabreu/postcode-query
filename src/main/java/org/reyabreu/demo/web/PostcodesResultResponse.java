package org.reyabreu.demo.web;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PostcodesResultResponse {

	private String country;
	private String region;

	@JsonCreator
	public PostcodesResultResponse(@JsonProperty(required = true) String country,
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
