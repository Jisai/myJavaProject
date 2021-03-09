package com.songj.threadAbout.threadPool.demo1;

import org.junit.Test;

import java.util.concurrent.*;

/**
 * @ClassNamee: ThreadPoolDemoTest
 * @Description: 主线程类
 * https://blog.csdn.net/wx5040257/article/details/78015025
 * @Author: Scott S
 * @Date: 2020-07-09 19:27
 * @Version: 1.0
 **/
public class ThreadPoolDemoTest {

    //创建线程池对象
    ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 200, TimeUnit.MILLISECONDS,
            new ArrayBlockingQueue<>(5));

    public static void main(String[] args) {
        //创建线程池对象
        ThreadPoolExecutor executorMain = new ThreadPoolExecutor(5, 8, 200, TimeUnit.MILLISECONDS,
                //有界队列
//                new ArrayBlockingQueue<>(5));
                //无界队列
                    new LinkedBlockingQueue<>());
//直接提交               new SynchronousQueue<>());
        //该线程用于对线程池的检测
        new Thread(new CheckTask(executorMain)).start();
        //预先创建所有的核心线程
        executorMain.prestartAllCoreThreads();
        //执行15个任务，但最多只有10个线程同时运行。
        for(int i = 1; i <= 15; i++){
            MyRunnable01 myTask01 = new MyRunnable01("mytask_" + i);
            executorMain.execute(myTask01);
        }
        executorMain.shutdown();
    }

    @Test
    public void test01(){
        //该线程用于对线程池的检测
        new Thread(new CheckTask(executor)).start();
        //预先创建所有的核心线程
        executor.prestartAllCoreThreads();
        //执行15个任务，但最多只有10个线程同时运行。
        for(int i = 1; i <= 15; i++){
            MyRunnable01 myTask01 = new MyRunnable01("mytask_" + i);
            executor.execute(myTask01);
        }
        executor.shutdown();
        // --------------
        try {
            Thread.sleep(1000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
