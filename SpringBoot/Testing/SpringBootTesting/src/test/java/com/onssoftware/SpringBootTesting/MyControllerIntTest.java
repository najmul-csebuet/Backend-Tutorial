package com.onssoftware.SpringBootTesting;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
@AutoConfigureMockMvc
class MyControllerIntTest {

    @Autowired
    private MockMvc mvc;

//    @Autowired
//    private TestRestTemplate testRestTemplate;

    @Test
    void test1() throws Exception {

        String url = "/hello?name=Najmul";
        String expectedContent = "Bismillah! Najmul";
        mvc.perform(MockMvcRequestBuilders.get(url)).andExpect(content().string(expectedContent));

        //String ans = testRestTemplate.getForObject(url, String.class);
        //assertThat(ans).isEqualTo(expectedContent);
    }
}