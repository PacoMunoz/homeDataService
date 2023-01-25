package com.pmg.homeapi.homeapi.controler;


import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class DataApiControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void addData() throws Exception {
        this.mockMvc.perform(post("/data")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"date\":\"12/12/2022\",\"temperature\":\"12\",\"humidity\":\"12\",\"position\":\"estudio\"}"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"));
    }
}
