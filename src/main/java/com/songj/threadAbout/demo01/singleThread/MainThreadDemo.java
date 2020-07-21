package com.songj.threadAbout.demo01.singleThread;


/**
 * @ClassNamee: MainThreadDemo
 * @Description: 单个线程 - 主线程业务测试用例
 * @Author: Scott S
 * @Date: 2020-07-17 14:19
 * @Version: 1.0
 **/
public class MainThreadDemo {

    public static void main(String[] args) {
//        test1();
//        test2();
        test3();
    }


    public static void test1(){
        //创建一个可运行的对象。
        MyRunnable_01 mr = new MyRunnable_01("我的线程");
        // 在对象上构建一个线程
        Thread myThread = new Thread(mr);
        //开始执行线程
        myThread.start();
        for(int i = 1; i <= 50; i++){
            try {
                //模拟主线程运行状态，间隔100ms打印一次。
                Thread.sleep(100);
                System.out.println(" 第 " + i + " 次检测结果：线程名称 - " + myThread.getName() + " ；线程运行状态 - " + myThread.isAlive());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("主线程执行完毕。");
    }

    public static void test2(){
        String threadName = "我的线程";
        Thread myThread = new Thread(new Runnable() {
            @Override
            public void run() {
                //模拟业务方法耗时ms
                try {
                    Thread.sleep(1000);
                    System.out.println("业务方法执行完毕。");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, threadName);
        myThread.start();
        for(int i = 1; i <= 50; i++){
            try {
                //模拟主线程运行状态，间隔100ms打印一次。
                Thread.sleep(100);
                System.out.println(" 第 " + i + " 次检测结果：线程名称 - " + myThread.getName() + " ；线程运行状态 - " + myThread.isAlive());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("主线程执行完毕。");
    }

    public static void test3(){
        String threadName = "我的线程";
        MyThread01 myThread = new MyThread01(threadName);
        for(int i = 1; i <= 50; i++){
            try {
                //模拟主线程运行状态，间隔100ms打印一次。
                Thread.sleep(100);
                System.out.println(" 第 " + i + " 次检测结果：线程名称 - " + myThread.getName() + " ；线程运行状态 - " + myThread.isAlive());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("主线程执行完毕。");
    }

}
