package com.onssoftware.SpringBootTesting;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

//@SpringBootTest
class MyControllerTest {

    @Test
    void test1() {
        var mc = new MyController();
        var a = mc.test("Najmul");
        assertEquals(a, "Bismillah! Najmul");
    }
}