package com.thread;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读锁
 */
public class ReentrantReadWriteLockRun {

    public static void main(String[] args) {
        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

        new Thread(() -> {
            try {
                lock.readLock().lock();

                System.out.println("readlock A 获得锁");

            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                lock.readLock().unlock();
            }
        }).start();
    }
}
