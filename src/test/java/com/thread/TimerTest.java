package com.thread;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by sunjx on 2017/11/3.
 */
public class TimerTest {

    class MyTask extends TimerTask{
        @Override
        public void run() {
            System.out.println("任务运行时间为 " + Calendar.getInstance().getTime().toLocaleString());
        }
    }

    //创建timer并设置timer的线程为守护线程,这样任务执行完后程序才会结束
    private Timer timer = new Timer();

    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    Calendar scheduleTime = Calendar.getInstance();

    //设置任务执行的时间
    Date scheduleDate ;

    String scheduleDateString ;

    //获取当前时间字符串
    private String nowDateString(){
        return Calendar.getInstance().getTime().toLocaleString();
    }

    public void before(){
        scheduleTime.add(Calendar.SECOND,5);
        scheduleDate = scheduleTime.getTime();
        scheduleDateString = scheduleDate.toLocaleString();
    }

    //5秒后执行
//    public static void main(String[] args) {
//        TimerTest programer = new TimerTest();
//        programer.before();
//
//        try {
//            System.out.println("当前时间为 " + programer.nowDateString());
//            System.out.println("定时时间为 " + programer.scheduleDateString);
//            programer.timer.schedule(programer.new MyTask(),programer.simpleDateFormat.parse(programer.scheduleDateString));
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//    }

    //5秒后开始执行，然后每3秒执行一次
//    public static void main(String[] args) {
//        TimerTest programer = new TimerTest();
//        programer.before();
//
//        try {
//            System.out.println("当前时间为 " + programer.nowDateString());
//            System.out.println("定时时间为 " + programer.scheduleDateString);
//            programer.timer.schedule(programer.new MyTask(), programer.simpleDateFormat.parse(programer.scheduleDateString) , 3000);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//    }

//    public static void main(String[] args) {
//        TimerTest programer = new TimerTest();
//        programer.before();
//        TimerTask task = programer.new MyTask();
//
//        try {
//            System.out.println("当前时间为 " + programer.nowDateString());
//            System.out.println("定时时间为 " + programer.scheduleDateString);
//            programer.timer.schedule(task, programer.simpleDateFormat.parse(programer.scheduleDateString) , 3000);
//            System.out.println("5秒后删除任务");
//            Thread.sleep(5000);
//            task.cancel();
//
//            System.out.println("5秒后删除timer");
//            Thread.sleep(5000);
//            programer.timer.cancel();
//
//            System.out.println("5秒后程序结束");
//            Thread.sleep(5000);
//
//        } catch (ParseException e) {
//            e.printStackTrace();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }

    public static void main(String[] args) {
        TimerTest programer = new TimerTest();
        programer.before();

        TimerTask task = new TimerTask() {
            boolean sleep = true;

            @Override
            public void run() {
                System.out.println("开始任务" + programer.nowDateString());
                if (sleep){
                    try {
                        System.out.println("延时5秒");
                        Thread.sleep(5000);
                        System.out.println("延时结束");
                        sleep = false;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("完成任务" + programer.nowDateString());
            }
        };

        try {
            System.out.println("当前时间为 " + programer.nowDateString());
            System.out.println("定时时间为 " + programer.scheduleDateString);

            //schedule 延时的情况
//            programer.timer.schedule(task, programer.simpleDateFormat.parse(programer.scheduleDateString), 3000);

            //scheduleAtFixedRate 延时的情况
            programer.timer.scheduleAtFixedRate(task, programer.simpleDateFormat.parse(programer.scheduleDateString), 3000);

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
