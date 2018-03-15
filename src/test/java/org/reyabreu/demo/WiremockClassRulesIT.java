package org.reyabreu.demo;

import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;

import com.github.tomakehurst.wiremock.junit.WireMockRule;

import org.junit.Rule;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WiremockClassRulesIT {

  @Rule
  public WireMockRule wireMockRule = new WireMockRule(wireMockConfig().httpsPort(8443));

}
