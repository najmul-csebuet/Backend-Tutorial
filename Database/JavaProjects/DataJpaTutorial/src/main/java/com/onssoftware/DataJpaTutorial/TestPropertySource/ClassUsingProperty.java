package com.onssoftware.DataJpaTutorial.TestPropertySource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ClassUsingProperty {

    @Value("${baeldung.testpropertysource.one:default-value1}")
    private String propertyOne;

    public String retrievePropertyOne() {
        return propertyOne;
    }
}
