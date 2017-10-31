package com.jxsun.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Administrator on 2017/9/20.
 */
public class ConditionDemo {
    static Account account = new Account();

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(new DepositTask());
        executorService.execute(new WithdrawTask());
        executorService.shutdown();
    }

    private static class Account {

        private static Lock lock = new ReentrantLock();

        private static Condition condition = lock.newCondition();

        private int balance = 0;

        //存款
        public void deposit(int num) {
            lock.lock();
            try {
                System.out.printf("存款 success :\t\t balance:%d , deposit:%d , now balance:%d\n", this.balance, num, this.balance + num);
                this.balance += num;
                condition.signalAll();
            } finally {
                lock.unlock();
            }
        }

        //取款
        public void withdraw(int num) {
            lock.lock();
            try {
                while (this.balance < num) {
                    try {
                        System.out.printf("取款 fail :\t\t\t balance:%d , withdraw:%d \n", this.balance, num);
                        condition.await();
                        System.out.println(num);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.printf("取款 success :\t\t balance:%d , withdraw:%d , now balance:%d\n", this.balance, num, this.balance - num);
                this.balance -= num;

            } finally {
                lock.unlock();
            }
        }

        public int getBalance() {
            return this.balance;
        }
    }

    //存款任务
    private static class DepositTask implements Runnable {
        public void run() {

            try {
                while (true) {
                    account.deposit((int) (Math.random() * 100));
                    Thread.sleep(500);
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //取款任务
    private static class WithdrawTask implements Runnable {
        public void run() {
            try {
                while (true) {
                    account.withdraw((int) (Math.random() * 100));
                    Thread.sleep(10);
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
