package com.onssoftware;

import java.util.Arrays;

public class QuickTest {
    int[] ar = {3,4,5,6,7,8,9,0};

    void test(int[] ar) {

    }

    public static void main(String[] args) {

        new QuickTest().test(new int[]{2, 3, 4, 5});

        boolean equals = Arrays.equals(new int[]{}, new int[]{});
        boolean equals1 = Arrays.equals(new int[]{5}, new int[]{3});
        boolean equals2 = Arrays.equals(new int[]{5}, new int[]{5});

        boolean equals3 = Arrays.equals(new double[]{5}, new double[]{5.0000000000001});

        System.out.println();

        dateTimeTest();
    }

    private static void dateTimeTest() {

    }
}
