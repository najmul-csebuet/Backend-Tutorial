package com.onssoftware.testingDemo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@WebMvcTest(MyController.class)
@SpringBootTest
class MyControllerIntTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    void test1() throws Exception {

        String url = "/hello?name=najmul";
        String expectedContent = "Bismillah! Najmul";
        mvc.perform(MockMvcRequestBuilders.get(url)).andExpect(content().string(expectedContent));

        String ans = testRestTemplate.getForObject(url, String.class);
        assertThat(ans).isEqualTo(expectedContent);
    }
}