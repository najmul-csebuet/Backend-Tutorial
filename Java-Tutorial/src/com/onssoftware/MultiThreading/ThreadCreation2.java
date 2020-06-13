package com.onssoftware.MultiThreading;

public class ThreadCreation2 implements Runnable {

    @Override
    public void run() {
        System.out.println("Bismilah");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {

        ThreadCreation2 threadCreation2 = new ThreadCreation2();
        Thread thread = new Thread(threadCreation2, "Najmul");
        thread.start();
        thread.join();

        System.out.println("Alhamdulillah");
    }
}
