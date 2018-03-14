package org.reyabreu.demo.web;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PostcodesResponseResource {

	private String status;
	private PostcodesResultResponse result;

	@JsonCreator
	public PostcodesResponseResource(@JsonProperty(required = true) String status,
			@JsonProperty(required = true) PostcodesResultResponse result) {
		super();
		this.status = status;
		this.result = result;
	}

	public PostcodesResultResponse getResult() {
		return result;
	}

	public String getStatus() {
		return status;
	}
}
