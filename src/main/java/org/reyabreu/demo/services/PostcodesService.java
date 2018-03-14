package org.reyabreu.demo.services;

import java.util.List;

import org.reyabreu.demo.domain.PostcodeDetails;

public interface PostcodesService {

	PostcodeDetails findDetails(final String postcode);

	boolean validate(final String postcode);

	List<PostcodeDetails> findNearest(final String postcode);

}
