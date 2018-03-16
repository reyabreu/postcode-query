package org.reyabreu.demo.gateway.services;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("/")
public class PostcodesRestClientIT {

  @Autowired
  private TestRestTemplate restTemplate;

  private PostcodesRestClient postcodesRestClient;


  @Test
  public void test() {
    fail("Not yet implemented");
  }

}
