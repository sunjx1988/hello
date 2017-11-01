package com.thread;

/**
 * Created by Administrator on 2017/11/1.
 */
public class TreadStopRun {

    public static void main(String[] args) throws InterruptedException {
//        MyThread thread = new MyThread();
////        MyThread2 thread = new MyThread2();
//        thread.start();
//        Thread.sleep(2000);
//        thread.interrupt();
//        System.out.println("main end");

//        MyThread3 thread3 = new MyThread3();
//        thread3.start();
//        Thread.sleep(200);
//        thread3.interrupt();
//        System.out.println("main end");

        MyThread4 thread4 = new MyThread4();
        thread4.start();
        Thread.sleep(200);
        thread4.interrupt();
        System.out.println("main end");
    }

}

//只使用interrupt 线程是停止不了的，只是跳出了for循环
class MyThread extends Thread {

    public void run() {

        for (int i = 0; ; i++) {
            if (this.interrupted()) {
                System.out.println("已经是停止状态，要break了");
                break;
            }
            System.out.println("i=" + i);
        }

        System.out.println("这句的执行表明：停止了for，线程还能执行，并未真正停止");
    }
}

//异常法停止
class MyThread2 extends Thread {

    public void run() {
        try {
            for (int i = 0;i<Integer.MAX_VALUE ; i++) {
                if (this.interrupted()) {
                    System.out.println("已经是停止状态，要break了");
                    throw new InterruptedException();
                }
                System.out.println("i=" + i);
            }

            System.out.println("这句的执行表明：停止了for，线程还能执行，并未真正停止");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

//sleep后停止线程
class MyThread3 extends Thread{

    @Override
    public void run() {
        try {
            super.run();
            System.out.println("run begin");
            Thread.sleep(10000);
            System.out.println("run end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

//使用return
class MyThread4 extends Thread{
    @Override
    public void run() {
        super.run();

        while (true){
            System.out.println("running...");
            if (this.interrupted()){
                return ;
            }
        }
    }
}


