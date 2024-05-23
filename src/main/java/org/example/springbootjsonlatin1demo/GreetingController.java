package org.example.springbootjsonlatin1demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

  private final ObjectMapper objectMapper;

  @Autowired
  public GreetingController(final ObjectMapper objectMapper) {
    this.objectMapper = objectMapper;
  }

  @GetMapping("/api/greetings")
  public void greetings(final HttpServletResponse response) throws IOException {
    final var result = new Greeting("Hello, world!");
    final String json = objectMapper.writeValueAsString(result);
    response.getWriter().write(json);
    response.setContentType(MediaType.APPLICATION_JSON_VALUE);
  }

  public record Greeting(String message) {

  }
}
