package com.thread;

import sun.security.jca.GetInstance;

/**
 * Created by sunjx on 2017/11/3.
 */
public class SingleTest {


}

/**
 * 立即模式或者叫饿汉模式
 * 缺点是不能有其他实例变量，因为getInstance方法没有同步，可能存在线程不安全问题
 */
class Object1{

    private static Object1 obj = new Object1();

    private Object1(){}

    public static Object1 getInstance(){
        return obj;
    }
}

/**
 * 延迟加载或者叫懒汉模式
 * 缺点是如果在多线程环境中可能出现取得多个实例
 */
class Object2{

    private static Object2 obj;

    private Object2(){}

    public static Object2 getInstance(){
        if(null == obj){
            obj = new Object2();
        }
        return obj;
    }
}

/**
 * 使用DCL双检查锁机制后的延迟加载单例模式
 */
class Object3{
    private static Object3 obj;

    private Object3(){}

    public static Object3 getInstance(){
        if(null == obj){

            //do something

            try {
                //这里的同步块只用来创建新对象，保证锁不会占用太长时间
                synchronized (Object3.class){
                    if(null == obj){
                        obj = new Object3();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return obj;
    }
}

/**
 * 这种方式是Object4类被装载了，obj不一定被初始化。
 * 因为Inner类没有被主动使用，只有显示通过调用getInstance方法时，才会显示装载Inner类，从而实例化obj。
 */
class Object4{
    private static class Inner{
        private static Object4 obj = new Object4();
    }

    private Object4(){}

    public static Object4 getInstance(){
        return Inner.obj;
    }
}

/**
 * 枚举方式，它不仅能避免多线程同步问题，而且还能防止反序列化重新创建新的对象
 */
class Singleton {

    enum SingletonEnum{

        FACTORY;
        private Singleton instance;

        //枚举的构造方法
        SingletonEnum() {
            instance = new Singleton();
        }

        Singleton getInstance(){
            return instance;
        }
    }

    private Singleton(){}

    public static Singleton getInstance(){
        return SingletonEnum.FACTORY.getInstance();
    }
}