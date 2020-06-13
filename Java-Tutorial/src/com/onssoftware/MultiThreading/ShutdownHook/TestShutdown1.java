package com.onssoftware.MultiThreading.ShutdownHook;

import com.onssoftware.MultiThreading.TestCallRun2;

public class TestShutdown1{
    public static void main(String[] args)throws Exception {

        Runtime runtime = Runtime.getRuntime();
        runtime.addShutdownHook(new TestCallRun2());
        runtime.addShutdownHook(new MyThread());

        System.out.println("Now main sleeping... press ctrl+c to exit");
        try{Thread.sleep(3000);}catch (Exception e) {}
    }
}
