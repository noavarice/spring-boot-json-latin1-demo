package org.example.springbootjsonlatin1demo;

import com.intuit.karate.junit5.Karate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class KarateTest {

  @Autowired
  @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
  public void setLocalPort(@LocalServerPort final int port) {
    System.setProperty("local.server.port", Integer.toString(port));
  }

  @Karate.Test
  Karate testGetGreetings() {
    return Karate.run("classpath:/get-greetings.feature");
  }
}
