package com.thread;

/**
 * Created by sunjx on 2017/11/3.
 */
public class ThreadExceptionTest {

    public static void main(String[] args) {

        Thread thread = new Thread();

        //对指定线程中的异常进行处理
        thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                //dosomething
                e.printStackTrace();
            }
        });

        //对所有的线程异常进行处理
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                //dosomething
                e.printStackTrace();
            }
        });
    }
}
