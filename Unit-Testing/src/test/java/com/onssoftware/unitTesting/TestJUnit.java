package com.onssoftware.unitTesting;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

//@SpringBootTest
public class TestJUnit {

    @Test
    public void checkingAdd() {
        System.out.println("Bismillah");
        assertEquals(8,4+4);
    }
}
