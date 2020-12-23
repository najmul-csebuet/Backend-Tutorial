package com.onssoftware.unitTesting;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.annotation.security.RunAs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TestJUnit {

    //@Mock
    ObjectMapper objectMapper;

    @Test
    public void checkingAdd() {
        assertEquals(8,4+4);
    }

    @Test
    void should_throw_exception_on_invalid_json() throws JsonProcessingException {
        objectMapper = Mockito.mock(ObjectMapper.class);
//        final String invalidJsonMsg = "{clientUrl:http://foo.de}";//JsonParseException
        final String invalidJsonMsg = "{\"clientUrl\":\"http://foo.de\"}";//UnrecognizedPropertyException
//        final String invalidJsonMsg = "{clientUrl}";

        NotificationDetails notificationDetails = objectMapper.readValue(invalidJsonMsg, NotificationDetails.class);
        System.out.println();

//        when(objectMapper.readValue(invalidJsonMsg, NotificationDetails.class)).thenThrow(new JsonProcessingException("JSON error"));

        doThrow(JsonParseException.class).when(objectMapper).readValue(invalidJsonMsg, NotificationDetails.class);

        //objectMapper.readValue(invalidJsonMsg, NotificationDetails.class);
        //ObjectMapper realObjectMapper = new ObjectMapper();
        assertThrows(JsonParseException.class,
                () -> objectMapper.readValue(invalidJsonMsg, NotificationDetails.class));
        /*assertThatThrownBy(() -> objectMapper.readValue(invalidJsonMsg, NotificationDetails.class))
                .isInstanceOf(JsonProcessingException.class);*/
    }
}

class NotificationDetails {
    private String clientUrl = "";
    NotificationDetails(){}

    public String getClientUrl() {
        return clientUrl;
    }

    public void setClientUrl(String clientUrl) {
        this.clientUrl = clientUrl;
    }
}
