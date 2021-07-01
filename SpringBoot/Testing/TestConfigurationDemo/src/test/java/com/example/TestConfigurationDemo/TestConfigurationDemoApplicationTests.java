package com.example.TestConfigurationDemo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.TestPropertySource;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Import(WebClientTestConfiguration.class)
//@TestPropertySource(locations = "classpath:application-test.properties")
@Profile("test")
class TestConfigurationDemoApplicationTests {

	@Autowired
	private DataService dataService;

	@Test
	void contextLoads() {
		assertThat(dataService).isNotNull();
	}

}
