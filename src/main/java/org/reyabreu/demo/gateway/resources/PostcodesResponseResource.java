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
