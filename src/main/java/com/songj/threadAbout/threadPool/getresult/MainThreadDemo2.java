package com.songj.threadAbout.threadPool.getresult;

import com.songj.threadAbout.threadPool.demo1.CheckTask;
import com.songj.threadAbout.threadPool.demo1.MyCallable01;
import com.songj.threadAbout.threadPool.demo1.MyRunnable01;

import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @ClassNamee: MainThreadDemo2
 * @Description: 主线程类 2
 * 实现 Callable 接口 实现。
 * @Author: Scott S
 * @Date: 2020-07-15 18:50
 * @Version: 1.0
 **/
public class MainThreadDemo2 {
    //向线程池提交一个单独的任务并得到任务执行的结果
    public static void subTask(ThreadPoolExecutor executor){
        Future<Integer> fut=executor.submit(new MyCallable01());

        try {
            //当然这里我们还可以中途终止任务的执行，但也有可能终止不了。
            //Thread.currentThread().sleep(15000);
            //fut.cancel(true);//15秒后取消任务的执行
            Integer result=fut.get();
            System.out.println("单独提交的任务执行结果:"+result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // 创建线程池对象
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 200, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());
        // 该线程用于对线程池的检测
        new Thread(new CheckTask(executor)).start();
        try {
            //执行15个任务
            for (int i = 1; i <= 15; i++) {
                MyRunnable01 myTask = new MyRunnable01("task==" + i);
                executor.execute(myTask);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //向线程池提交一个单独的任务并得到任务执行的结果
        subTask(executor);
        executor.shutdown();
    }

}
