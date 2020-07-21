package com.songj.threadAbout;

import com.google.common.util.concurrent.*;
import org.junit.Test;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @ClassNamee: GuavaListenableFutureLearn
 * @Description: 从Java Future 到 Guava ListenableFuture实现异步非阻塞调用
 * https://blog.csdn.net/fly910905/article/details/80861296
 * @Author: Scott S
 * @Date: 2019-12-31 15:05
 * @Version: 1.0
 **/
public class GuavaListenableFutureLearn {

    // 创建线程池
    final static ExecutorService futureService = Executors.newCachedThreadPool();

    // 创建线程池
    final static ListeningExecutorService guavaService = MoreExecutors.listeningDecorator(Executors.newCachedThreadPool());

    /**
     * @Description: FutureTask
     * Executor框架利用FutureTask来完成异步任务，并可以用来进行任何潜在的耗时的计算。
     * 一般FutureTask多用于耗时的计算，主线程可以在完成自己的任务后，再去获取结果。
     * FutureTask包装了Callable和Runnable接口对象,提供对Future接口的基本实现，开始、取消计算、查询计算是否完成、获取计算结果。
     * 仅当计算完成时才能检索结果，当计算没有完成时，该方法会一直阻塞直到任务转入完成状态。
     * 一旦完成计算，不能够重新开始或取消计算。
     * 可以通过Excutor(线程池)来执行,也可传递给Thread对象执行。
     * 如果在主线程中需要执行比较耗时的操作时，但又不想阻塞主线程时，可以把这些作业交给Future对象在后台完成，当主线程将来需要时，就可以通过Future对象获得后台作业的计算结果或者执行状态。
     * @auther: Scott S
     * @date: 2019/12/31 15:09
     */
    @Test
    public void futureTest() throws InterruptedException, ExecutionException {
        Long t1 = System.currentTimeMillis();

        // 任务1
        Future<Boolean> booleanTask = futureService.submit(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return true;
            }
        });

        while (true) {
            if (booleanTask.isDone() && !booleanTask.isCancelled()) {
                //模拟耗时
                Thread.sleep(500);
                Boolean result = booleanTask.get();
                System.err.println("BooleanTask: " + result);
                break;
            }
        }

        // 任务2
        Future<String> stringTask = futureService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "Hello World";
            }
        });

        while (true) {
            if (stringTask.isDone() && !stringTask.isCancelled()) {
                String result = stringTask.get();
                System.err.println("StringTask: " + result);
                break;
            }
        }

        // 任务3
        Future<Integer> integerTask = futureService.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return new Random().nextInt(100);
            }
        });

        while (true) {
            if (integerTask.isDone() && !integerTask.isCancelled()) {
                Integer result = integerTask.get();
                System.err.println("IntegerTask: " + result);
                break;
            }
        }

        // 执行时间
        System.err.println("time: " + (System.currentTimeMillis() - t1));
    }


    /**
     * @Description: guava
     * （减少主函数的等待时间，使得多任务能够异步非阻塞执行）
     * ListenableFuture顾名思义就是可以监听的Future，它是对java原生Future的扩展增强。
     * 我们知道Future表示一个异步计算任务，当任务完成时可以得到计算结果。
     * 如果我们希望一旦计算完成就拿到结果展示给用户或者做另外的计算，就必须使用另一个线程不断的查询计算状态。这样做，代码复杂，而且效率低下。
     * 使用ListenableFuture Guava帮我们检测Future是否完成了，如果完成就自动调用回调函数，这样可以减少并发程序的复杂度。
     * @auther: Scott S
     * @date: 2019/12/31 16:18
     */
    @Test
    public void guavaFutureTest() throws Exception {
        Long t1 = System.currentTimeMillis();
        // 任务1
        ListenableFuture<Boolean> booleanTask = guavaService.submit(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return true;
            }
        });

        Futures.addCallback(booleanTask, new FutureCallback<Boolean>() {
            @Override
            public void onSuccess(Boolean result) {
                System.err.println("BooleanTask: " + result);
            }

            @Override
            public void onFailure(Throwable t) {
            }
        });

        // 任务2
        ListenableFuture<String> stringTask = guavaService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                StringBuffer stringBuffer = new StringBuffer();
                for(int i = 1; i < 10; i++){
                    String batchRes = "我是第" + i + "次循环的结果；";
                    stringBuffer.append(batchRes);
                }
                return stringBuffer.toString();
            }
        });

        Futures.addCallback(stringTask, new FutureCallback<String>() {
            @Override
            public void onSuccess(String result) {
                System.err.println("StringTask: " + result);
            }

            @Override
            public void onFailure(Throwable t) {
                System.out.println("执行了onFailure()");
            }
        });

        // 任务3
        ListenableFuture<Integer> integerTask = guavaService.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return new Random().nextInt(100);
            }
        });

        Futures.addCallback(integerTask, new FutureCallback<Integer>() {
            @Override
            public void onSuccess(Integer result) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.err.println("IntegerTask: " + result);
            }

            @Override
            public void onFailure(Throwable t) {
            }
        });

        // 执行时间
        System.err.println("time: " + (System.currentTimeMillis() - t1));
    }


}
