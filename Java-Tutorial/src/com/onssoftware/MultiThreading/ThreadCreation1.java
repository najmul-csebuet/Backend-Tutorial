package com.onssoftware.MultiThreading;

public class ThreadCreation1 extends Thread {
    @Override
    public void run() {
        System.out.println("Bismillah");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {

        ThreadCreation1 threadCreation1 = new ThreadCreation1();
        threadCreation1.setName("NajmulThread");

        threadCreation1.start();
        //threadCreation1.join();

        Thread.currentThread().join(5000);
        System.out.println("Alhamdulillah");
    }
}
