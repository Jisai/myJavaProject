package com.songj.threadAbout.threadPool.demo1;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @ClassNamee: CheckTask
 * @Description: 线程检测类
 * @Author: Scott S
 * @Date: 2020-07-09 18:34
 * @Version: 1.0
 **/
public class CheckTask implements Runnable{

    ThreadPoolExecutor executor;

    public CheckTask(ThreadPoolExecutor executor) {
        this.executor = executor;
    }

    /**
     * @Description: 线程检测
     * @param: [executor, i]
     */
    public void showPoolInfo(ThreadPoolExecutor executor, int i){
        System.out.println(" - - - 第 " + i + " 次线程检测 Start - - - " );
        //线程池中核心线程数
        int corePoolSize = executor.getCorePoolSize();
        //线程池中活跃线程数
        int activeCount = executor.getActiveCount();
        //线程池中允许的最大线程数
        int maximumPoolSize = executor.getMaximumPoolSize();
        //队列中等待执行的任务数目
        int queueTaskSize = executor.getQueue().size();
        //已经执行完的任务数目
        long completedTaskCount = executor.getCompletedTaskCount();

        System.out.println("线程池中核心线程数:" + corePoolSize + "；允许的最大线程数:" + maximumPoolSize + "；活跃线程数:" + activeCount
                + "；队列中等待执行的任务数目:" + queueTaskSize + "；已经执行完的任务数目:" + completedTaskCount);
        System.out.println(" - - -  第 " + i + " 次线程检测 End  - - - ");
    }

    @Override
    public void run() {
        int cut = 0;
        while (true){
            cut ++;
            try {
                //每过1s检测一次
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            showPoolInfo(executor, cut);
            if(executor.isTerminated()){
                break;
            }
        }

    }
}
