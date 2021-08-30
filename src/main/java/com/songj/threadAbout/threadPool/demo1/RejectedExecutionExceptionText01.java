package com.songj.threadAbout.threadPool.demo1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassNamee: TextExecutor01
 * @Description: 解决java.util.concurrent.RejectedExecutionException
 * https://blog.csdn.net/wzy_1988/article/details/38922449
 * @Author: Scott S
 * @Date: 2020-07-10 11:15
 * @Version: 1.0
 **/
public class RejectedExecutionExceptionText01 {
    //通过源码我们可以发现最后他们均调用了ThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) 方法。
    //固定大小线程池
    public ExecutorService fixedExecutorService = Executors.newFixedThreadPool(5);
    //无界线程池，可以进行自动线程回收
    public ExecutorService cachedExecutorService = Executors.newCachedThreadPool();
    //单个后台线程
    public ExecutorService singleExecutorService = Executors.newSingleThreadExecutor();

    public void testExecutorException() {
        for (int i = 0; i < 10; i ++) {
            fixedExecutorService.execute(new SayHelloRunnable());
            fixedExecutorService.shutdown();
        }

        //1. 不要显示的调用shutdown方法，例如Android里，只有你在Destory方法里cancel掉AsyncTask，则线程池里没有活跃线程会自己回收自己。
        //2. 调用线程池时，判断是否已经shutdown，通过API方法isShutDown方法判断。
//        for (int i = 0; i < 10; i ++) {
//            // 增加isShutdown()判断
//            if (!fixedExecutorService.isShutdown()) {
//                fixedExecutorService.execute(new SayHelloRunnable());
//            }
//            fixedExecutorService.shutdown();
//        }

    }

    private class SayHelloRunnable implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } finally {
                System.out.println("hello world!");
            }

        }
    }

    public static void main(String[] args) {
        RejectedExecutionExceptionText01 testExecutor = new RejectedExecutionExceptionText01();
        testExecutor.testExecutorException();
    }

}
