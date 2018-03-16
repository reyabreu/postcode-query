package org.reyabreu.demo.gateway.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.reyabreu.demo.domain.PostcodeDetails;
import org.springframework.stereotype.Component;

@Component
public class PostcodeDetailsAssembler {

  public PostcodeDetails toPostcodeDetails(LookupResultResource resultResource) {
    return PostcodeDetails.builder().postcode(resultResource.getPostcode()).country(resultResource.getCountry())
        .region(resultResource.getRegion()).build();
  }

  public PostcodeDetails toPostcodeDetails(LookupResource resource) {
    return toPostcodeDetails(resource.getResult());
  }

  public List<PostcodeDetails> toPostcodeDetailsList(NearestResource resource) {
    return resource.getResult().stream().map(this::toPostcodeDetails).collect(Collectors.toList());
  }

}
