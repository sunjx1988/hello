package com.jxsun.thread;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/11/2.
 */
public class ConsumerAndProducter {

    private List<Object> store = new ArrayList<Object>(1);

    class Consumer{

        private Object lock;

        public Consumer(Object lock){
            this.lock = lock;
        }

        void consum(){
            try {
                synchronized (lock){
                    //如果此处改为 if 则在多个consumer的情况下，有可能会出现 store.remove(0) 的时候 store正好为空导致异常
                    while (store.isEmpty()){
                        System.out.println("consum : store is empty ,waitting...");
                        lock.wait();
                    }
                    store.remove(0);
                    lock.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    class Producter{

        private Object lock;

        public Producter(Object lock){
            this.lock = lock;
        }

        void product(){
            try {
                synchronized (lock){
                    //如果此处改为 if 则在多个consumer的情况下，有可能会出现 store.add(new Object()); 的时候 store正好不为空导致store.size 大于我们预设值
                    while (!store.isEmpty()){
                        System.out.println("product : store is not empty ,waitting...");
                        lock.wait();
                    }
                    store.add(new Object());
                    lock.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
        ConsumerAndProducter programer = new ConsumerAndProducter();
        Object lock = new Object();
        Consumer consumer = programer.new Consumer(lock);
        Producter producter = programer.new Producter(lock);

        new Thread(() -> {
            while (true){
                consumer.consum();
            }
        }).start();

        new Thread(() -> {
            while (true){
                producter.product();
            }
        }).start();
    }
}
