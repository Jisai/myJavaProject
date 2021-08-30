package com.songj.threadAbout.threadPool.getresult;

import com.songj.threadAbout.threadPool.demo1.CheckTask;

import java.util.concurrent.*;

/**
 * @ClassNamee: MainThreadDemo1
 * @Description: 主线程类 1
 * 内部类 Callable 实现。
 * @Author: Scott S
 * @Date: 2020-07-14 14:55
 * @Version: 1.0
 **/
public class MainThreadDemo1 {

    //向线程池提交一个单独的任务并得到任务执行的结果
    public static void subTask(ThreadPoolExecutor executor){
        Future<Integer> future = executor.submit(new Callable<Integer>(){

            @Override
            public Integer call() throws Exception {
                System.out.println("主线程类-1 >>  计算任务开始执行...");
                int sum = 0;
                for(int i = 0; i < 100; i++){
                    Thread.sleep(100);
                    sum ++;
                }
                System.out.println("主线程类-1  计算任务执行结束。");
                return sum;
            }
        });

        try {
            Integer result = future.get();
            System.out.println("主线程类-1 >> 单独提交的任务执行结果: " + result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        //创建线程池对象
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10,
                500, TimeUnit.MINUTES, new LinkedBlockingQueue<Runnable>());
//                500, TimeUnit.MINUTES, new ArrayBlockingQueue<Runnable>(20));
        //该线程用于对线程池进行检测
        new Thread(new CheckTask(executor)).start();

        for(int i = 1; i<= 15; i++){
//            MyRunnable01 myTask01 = new MyRunnable01("task-" + i);
//            //使用execute：异步执行debug能看出来，执行顺序；异步执行完美。用debug看能看出来，不然没这效果。
//            //且当提交的任务中出现异常：则不抛出错误！！！！！！！
//            executor.execute(myTask01);

            executor.execute(() -> {
                try {
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("任务正在执行。。。");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

        }
        //向线程池提交一个单独的任务并得到任务执行的结果。
        //submit有返回值，如果get里面返回结果，就是相当于并发提交任务，
        // 结果集需要同步执行，主线程还是同步方法（只是提交任务可以处理并发任务），如果获取结果集，也可以用作简单的异步使用。
//        subTask(executor);
        executor.shutdown();

    }

}
