package com.onssoftware.MultiThreading.ProducerConsumer;

import java.util.LinkedList;
import java.util.List;

public class PC {

    int capacity = 2;
    private List<Integer> list = new LinkedList<>();

    public void produce() throws InterruptedException {
        int value = 0;
        while (true) {
            synchronized (this) {
                while (list.size() == capacity) {
                    wait();
                }

                list.add(++value);
                System.out.println("Produced: " + value);
                notify();
                Thread.sleep(1000);
            }
        }
    }

    public void consume() throws InterruptedException {
        while (true) {
            synchronized (this) {
                while (list.size() == 0)wait();
                int value = list.remove(0);
                System.out.println("Consumed: " + value);
                notify();
                Thread.sleep(1000);
            }
        }
    }
}
