package org.reyabreu.demo.gateway.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.reyabreu.demo.domain.PostcodeDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class PostcodeDetailsAssembler {

  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  public PostcodeDetails toPostcodeDetails(LookupResultResource resultResource) {
    PostcodeDetails result =
        PostcodeDetails.builder().postcode(resultResource.getPostcode()).country(resultResource.getCountry())
        .region(resultResource.getRegion()).build();
    logger.debug("Postcode Details assembled: {}", result);
    return result;
  }

  public PostcodeDetails toPostcodeDetails(LookupResource resource) {
    return toPostcodeDetails(resource.getResult());
  }

  public List<PostcodeDetails> toPostcodeDetailsList(NearestResource resource) {
    return resource.getResult().stream().map(this::toPostcodeDetails).collect(Collectors.toList());
  }

}
