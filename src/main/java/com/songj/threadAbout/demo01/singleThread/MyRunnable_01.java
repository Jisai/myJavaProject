package com.songj.threadAbout.demo01.singleThread;

/**
 * @ClassNamee: MyRunnable_01
 * @Description:  单一线程 - 我自己的线程_01
 * @Author: Scott S
 * @Date: 2020-07-17 14:13
 * @Version: 1.0
 **/
public class MyRunnable_01 implements Runnable {

    private String name;

    public MyRunnable_01(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("com.songj.threadAbout.demo01.singleThread.MyRunnable_01 " +  name + " 线程任务 开始 。。。");
        try {
            //模拟业务方法耗时ms
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("com.songj.threadAbout.demo01.singleThread.MyRunnable_01 " +  name + " 线程任务 结束。");
    }
}
