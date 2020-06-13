package com.onssoftware.MultiThreading;

public class TestJoinMethod1 extends Thread {
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(i+1);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {

        TestJoinMethod1 t1 = new TestJoinMethod1();
        TestJoinMethod1 t2 = new TestJoinMethod1();
        TestJoinMethod1 t3 = new TestJoinMethod1();

        t1.start();
        t1.join();

        t2.start();
        t3.start();
    }
}
