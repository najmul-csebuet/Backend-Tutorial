package com.onssoftware.Enums;

enum Test {
    T, TT;
    int h;
    Integer hh;

    void test() {
        h = 5;
        System.out.println(h);
    }
}

class FreshJuice {
    enum FreshJuiceSize {SMALL, MEDIUM, LARGE}
    FreshJuiceSize freshJuiceSize;
}

public class FreshJuiceTest {
    public static void main(String[] args) {
        FreshJuice freshJuice = new FreshJuice();
        freshJuice.freshJuiceSize = FreshJuice.FreshJuiceSize.LARGE;
        System.out.println("Size: " + freshJuice.freshJuiceSize);

        Test t = Test.T;
        t.test();

        int h;
        System.out.println(h);
    }
}
