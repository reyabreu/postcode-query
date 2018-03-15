package org.reyabreu.demo.gateway.resources;

import org.reyabreu.demo.domain.PostcodeDetails;
import org.springframework.stereotype.Component;

@Component
public class PostcodeDetailsAssembler {

  public PostcodeDetails toPostcodeDetails(final PostcodesResponseResource resource) {
    final PostcodesResultResponseResource resultResource = resource.getResult();
    return new PostcodeDetails(resultResource.getCountry(), resultResource.getRegion());
  }

}
