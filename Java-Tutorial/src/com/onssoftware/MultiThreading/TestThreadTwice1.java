package com.onssoftware.MultiThreading;

public class TestThreadTwice1 extends Thread{

    public void run(){
        while (true) {
            System.out.println("running...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String args[]){
        TestThreadTwice1 t1 = new TestThreadTwice1();
        t1.start();
        t1.start();
    }
}
