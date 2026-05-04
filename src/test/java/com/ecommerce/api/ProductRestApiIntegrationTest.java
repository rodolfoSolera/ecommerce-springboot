package com.ecommerce.api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.Matchers.is;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductRestApiIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testGetAllProducts() throws Exception {
        mockMvc.perform(get("/api/products"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").isNotEmpty())
                .andExpect(jsonPath("$.length()", is(70)))
                .andExpect(jsonPath("$[0].id").exists())
                .andExpect(jsonPath("$[0].id").isNumber())
                .andExpect(jsonPath("$[0].name").exists())
                .andExpect(jsonPath("$[0].name").isString())
                .andExpect(jsonPath("$[0].category").exists())
                .andExpect(jsonPath("$[0].category").isString())
                .andExpect(jsonPath("$[0].price").exists())
                .andExpect(jsonPath("$[0].price").isNumber())
                .andExpect(jsonPath("$[0].state").exists())
                .andExpect(jsonPath("$[0].state").isString())
                .andExpect(jsonPath("$[0].description").exists())
                .andExpect(jsonPath("$[0].description").isString());
    }
}
