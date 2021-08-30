package com.songj.timer;

import java.sql.Time;
import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName: TimeTest
 * @Description: java当中的定时器的4种使用方式
 * @Author: Scott S
 * @Date: 2018-09-25 10:44
 * @Version: 1.0
 */
public class TimeTest {

    public static void main(String[] args) {
        timer01();
//        timer02();
//        timer03();
//        timer04();
//        timer05();
    }


    /**
     * 设定指定任务task在指定时间time执行 schedule(TimerTask task, Date time)
     */
    public static void timer01(){
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("--- 设定要指定的定时任务！ ---");
            }
        }, 2000);//设定指定的时间time，此处为2000毫秒。

    }

    /**
     * 设定指定任务task在指定延迟delay后进行固定延迟peroid的执行,
     * schedule(TimerTask task, long delay, long period)
     */
    public static void  timer02(){
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("--- 设定要指定的任务！ ---");
            }
        }, 1000, 5000);
    }


    /**
     * 设定指定任务task在指定延迟delay后进行固定频率peroid的执行。
     * scheduleAtFixedRate(TimerTask task, long delay, long period)
     */
    public static void timer03(){
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println("--- 设定要指定的任务！ ---");
            }
        }, 1000, 2000);
    }

    /**
     * 安排指定的任务task在指定的时间firstTime开始进行重复的固定速率period执行。
     * Timer.scheduleAtFixedRate(TimerTask task,Date firstTime,long period)
     * 在实现时，Timer类可以调度任务，TimerTask则是通过在run()方法里实现具体任务。 Timer实例可以调度多任务，它是线程安全的。
     * 当Timer的构造器被调用时，它创建了一个线程，这个线程可以用来调度任务。
     */
    public static void  timer04(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 12);//控制时
        calendar.set(Calendar.MINUTE, 0);//控制分
        calendar.set(Calendar.SECOND, 0);//控制秒

        Date time = calendar.getTime();//得出执行任务的时间，此处为今天的12:00:00

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println("--- 设定要指定的任务！ ---");
            }
        }, time, 1000 * 60 * 60 * 24);
    }

    public static void timer05(){
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("--- 设定要指定的任务！ ---");
            }
        };

        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        service.scheduleAtFixedRate(runnable, 10, 1, TimeUnit.SECONDS);
    }

}
