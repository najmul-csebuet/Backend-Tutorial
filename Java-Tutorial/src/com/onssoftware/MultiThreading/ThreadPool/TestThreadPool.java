package com.onssoftware.MultiThreading.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestThreadPool {

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 1; i <= 10; i++) {
            executorService.execute(new WorkerThread(i + ""));
        }

        System.out.println("Finished all threads");

        executorService.shutdown();

        /*while (!executorService.isTerminated()) {
            Thread.sleep(1000);
        }*/

    }
}
