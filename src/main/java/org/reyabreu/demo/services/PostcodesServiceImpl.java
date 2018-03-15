package org.reyabreu.demo.services;

import org.reyabreu.demo.domain.PostcodeDetails;
import org.reyabreu.demo.gateway.resources.LookupResource;
import org.reyabreu.demo.gateway.resources.PostcodeDetailsAssembler;
import org.reyabreu.demo.gateway.resources.ValidateResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    // TODO Auto-generated method stub
    return null;
  }

}
