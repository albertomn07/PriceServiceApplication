package com.example.inditex.endpoint;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import java.time.format.DateTimeFormatter;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
public class PriceControllerTest {
    @Autowired
    private MockMvc mockMvc;

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

    @Test
    public void testPriceAt10hDay14() throws Exception {
        mockMvc.perform(get("/api/prices/price")
                        .param("startDate", "2020-06-14T10:00:00")
                        .param("productId", "35455")
                        .param("brandId", "1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.productId").value("35455"))
                .andExpect(jsonPath("$.brandId").value("1"));
    }

    @Test
    public void testPriceAt16hDay14() throws Exception {
        mockMvc.perform(get("/api/prices/price")
                        .param("startDate", "2020-06-14T16:00:00")
                        .param("productId", "35455")
                        .param("brandId", "1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.productId").value("35455"))
                .andExpect(jsonPath("$.brandId").value("1"));
    }

    @Test
    public void testPriceAt21hDay14() throws Exception {
        mockMvc.perform(get("/api/prices/price")
                        .param("startDate", "2020-06-14T21:00:00")
                        .param("productId", "35455")
                        .param("brandId", "1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.productId").value("35455"))
                .andExpect(jsonPath("$.brandId").value("1"));
    }

    @Test
    public void testPriceAt10hDay15() throws Exception {
        mockMvc.perform(get("/api/prices/price")
                        .param("startDate", "2020-06-15T10:00:00")
                        .param("productId", "35455")
                        .param("brandId", "1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.productId").value("35455"))
                .andExpect(jsonPath("$.brandId").value("1"));
    }

    @Test
    public void testPriceAt21hDay16() throws Exception {
        mockMvc.perform(get("/api/prices/price")
                        .param("startDate", "2020-06-16T21:00:00")
                        .param("productId", "35455")
                        .param("brandId", "1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.productId").value("35455"))
                .andExpect(jsonPath("$.brandId").value("1"));
    }

}
