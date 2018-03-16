package org.reyabreu.demo.services;

import java.util.List;

import org.reyabreu.demo.domain.PostcodeDetails;
import org.reyabreu.demo.gateway.resources.LookupResource;
import org.reyabreu.demo.gateway.resources.NearestResource;
import org.reyabreu.demo.gateway.resources.PostcodeDetailsAssembler;
import org.reyabreu.demo.gateway.resources.ValidateResource;
import org.reyabreu.demo.gateway.services.PostcodesRestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostcodesServiceImpl implements PostcodesService {

  @Autowired
  private PostcodesRestClient client;

  @Autowired
  private PostcodeDetailsAssembler assembler;

  @Override
  public PostcodeDetails getDetails(String postcode) {
    LookupResource resource = client.lookup(postcode);
    return assembler.toPostcodeDetails(resource);
  }

  @Override
  public Boolean isValid(String postcode) {
    ValidateResource resource = client.validate(postcode);
    return resource.getResult();
  }

  @Override
  public List<PostcodeDetails> findNearestPostcodes(String postcode) {
    NearestResource resource = client.nearestPostcodes(postcode);
    return assembler.toPostcodeDetailsList(resource);
  }

}
