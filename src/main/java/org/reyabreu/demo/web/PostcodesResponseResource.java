package org.reyabreu.demo.web;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PostcodesResponseResource {

	private String status;
	private PostcodesResultResponseResource result;

	@JsonCreator
	public PostcodesResponseResource(@JsonProperty(required = true) String status,
			@JsonProperty(required = true) PostcodesResultResponseResource result) {
		super();
		this.status = status;
		this.result = result;
	}

	public PostcodesResultResponseResource getResult() {
		return result;
	}

	public String getStatus() {
		return status;
	}
}
