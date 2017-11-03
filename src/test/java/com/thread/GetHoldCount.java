package com.thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 当前锁被持有的次数
 */
public class GetHoldCount {

    private ReentrantLock lock = new ReentrantLock();

    private void method1(){
        try {
            lock.lock();
            System.out.println("hold count:" + lock.getHoldCount());
            //在这里调用方法2的时候上面已经获得了一次锁
            method2();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    private void method2(){
        try {
            lock.lock();
            System.out.println("hold count:" + lock.getHoldCount());
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        GetHoldCount program = new GetHoldCount();
        program.method1();
    }
}
