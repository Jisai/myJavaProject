package com.songj.threadAbout.demo01.multipleThread;

/**
 * @ClassNamee: MyRunnable_01
 * @Description:  我自己的线程_01
 * @Author: Scott S
 * @Date: 2020-07-17 14:13
 * @Version: 1.0
 **/
public class MyRunnable_01 implements Runnable {

    Thread thread;

    //构建一个线程
    MyRunnable_01(String name){
        thread = new Thread(this, name);
        //启动线程
        thread.start();
    }


    @Override
    public void run() {
        System.out.println("multipleThread.MyRunnable_01 " + thread.getName() + " 线程任务 开始 。。。");
        int sleepTime = (int) (Math.random() * 1000);
        try {
            //模拟业务方法耗时ms
            //随机事件
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            System.out.println("multipleThread.MyRunnable_01  " + thread.getName() + "   线程任务 中断。");
            e.printStackTrace();
        }
        System.out.println("multipleThread.MyRunnable_01  " + thread.getName() + "  线程任务 " + sleepTime +"ms 结束。");
    }
}
