package com.vsrukshan.demoDevops;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(controllers = controller.class) // Isolates the controller for testing
public class ControllerTest {


    private final MockMvc mockMvc;

    @Autowired
    public ControllerTest(MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }

    @Test
    public void getMessage_ReturnsSuccessResponse() throws Exception {
        // Perform a GET request to the "/api" endpoint
        mockMvc.perform(MockMvcRequestBuilders.get("/api"))
                .andExpect(MockMvcResultMatchers.status().isOk()) // Assert HTTP status 200
                .andExpect(MockMvcResultMatchers.content().string("Demo Response for DevOps assignment")); // Assert response body
    }
}
