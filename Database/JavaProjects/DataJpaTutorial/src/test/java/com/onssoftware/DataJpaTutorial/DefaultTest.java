package com.onssoftware.DataJpaTutorial;

import com.onssoftware.DataJpaTutorial.TestPropertySource.ClassUsingProperty;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;

import static org.assertj.core.api.Assertions.assertThat;

//@SpringBootTest
//@Import(value = {ClassUsingProperty.class})
@ContextConfiguration(classes = {ClassUsingProperty.class})
//@TestPropertySource(locations = "DefaultTest.properties")
@TestPropertySource(locations = "classpath:DefaultTest.properties")
//@TestPropertySource
public class DefaultTest {

    @Autowired
    ClassUsingProperty classUsingProperty;

    @Test
    public void givenDefaultTPS_whenVariableRetrieved_thenDefaultFileReturned() {
        String output = classUsingProperty.retrievePropertyOne();

        assertThat(output).isEqualTo("default-value");
    }
}
