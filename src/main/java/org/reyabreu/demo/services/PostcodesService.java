package org.reyabreu.demo.services;

import org.reyabreu.demo.domain.PostcodeDetails;

import java.util.List;

public interface PostcodesService {

  PostcodeDetails getDetails(final String postcode);

  Boolean isValid(final String postcode);

  List<PostcodeDetails> findNearestPostcodes(final String postcode);

}
