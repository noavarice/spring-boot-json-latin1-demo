package org.example.springbootjsonlatin1demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.test.web.servlet.MockMvc;

@DisplayName("Greetings API test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class MockMvcTest {

  private final MockMvc mockMvc;

  @Autowired
  MockMvcTest(final MockMvc mockMvc) {
    this.mockMvc = mockMvc;
  }

  @DisplayName("Check greetings API content type is OK when testing through MockMvc")
  @Test
  void testResponseContentType() throws Exception {
    mockMvc
        .perform(get("/api/greetings"))
        .andExpectAll(
            status().isOk(),
            header().stringValues(HttpHeaders.CONTENT_TYPE, "application/json")
        );
  }
}
