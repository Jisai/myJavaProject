package com.songj.threadAbout.threadPool.demo1;

/**
 * @ClassNamee: MyRunnable01
 * @Description: 任务类01
 * @Author: Scott S
 * @Date: 2020-07-09 19:07
 * @Version: 1.0
 **/
public class MyRunnable01 implements Runnable {

    String theTask;

    public MyRunnable01(String theTask) {
        this.theTask = theTask;
    }

    @Override
    public void run() {
        System.out.println(" 》 任务 " + theTask + " Start 。");
        try {
            //需要一定时间秒执行完毕
            long sleepTime = 1000;//(long) Math.random() * 10000;
            Thread.sleep(sleepTime);
            businessMethod01();
//            System.out.println("businessMethod01: " + businessMethod01());
//            System.out.println("任务 " + theTask + " 耗时" + sleepTime + "ms。");
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("...任务 " + theTask + " 被中断！！!");
        }
        System.out.println(" 《 任务 " + theTask + " End 。");
    }

    public String businessMethod01(){
        String result = "业务方法1 开始执行 ... 执行完毕。";
        System.out.println(result);
        return result;
    }



}
