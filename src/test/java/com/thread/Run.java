package com.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2017/8/20.
 */
public class Run {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(400);

        final A a = new A();

        for (int i = 0; i < 1000000; i++) {

            executorService.execute(new Runnable() {
                public void run() {
                    a.write(false);
                }
            });

            executorService.execute(new Runnable() {
                public void run() {
                    a.write(true);
                }
            });

            executorService.execute(new Runnable() {
                public void run() {
                    a.read();
                }
            });
        }

        executorService.shutdown();
    }
}

class A {
    boolean flag0 = false;
    boolean flag1 = false;

    synchronized void read() {
        if (flag1 != flag0) {
            System.out.println("oh...flag1 != flag0");
        }
    }

    synchronized void write(boolean newVal) {
        flag0 = newVal;
        flag1 = newVal;
    }
}
