package com.songj.threadAbout.demo01.singleThread;


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

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


    @Test
    public void getThreadResult() throws InterruptedException {
        List<Integer> result = new ArrayList<>();
        //固定大小线程池
        ExecutorService executorService = Executors.newFixedThreadPool(4);
//        ExecutorService executorService = Executors.newSingleThreadExecutor();
        List<Future<List<Integer>>> futureList = new ArrayList<>();
        for(int i = 0; i < 5; i++){
            String name = "线程" + i;
            Callable callback = new Callable<List<Integer>>() {
                @Override
                public List<Integer> call() throws Exception {
                    List<Integer>  list = getMockResult(name);
                    return list;
                }
            };

            Future<List<Integer>> future = executorService.submit(callback);
            futureList.add(future);
//            try {
//                //此处会阻塞线程执行，即多个线程在一个一个排队执行。
//                List<Integer> batchResult = future.get();
//                result.addAll(batchResult);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            } catch (ExecutionException e) {
//                e.printStackTrace();
//            }
        }
        List<Integer> batchResult = new ArrayList<>();
        for(Future<List<Integer>>   future : futureList){
            try {
                batchResult = future.get();
                result.addAll(batchResult);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        System.out.println("result.size=" + result.size());

    }

    /**
     * 模拟调用外部方法，耗时获取结果。
     */
    private List<Integer> getMockResult(String name) throws InterruptedException {
        System.out.println(name + " start.");
        List<Integer> result = new ArrayList<>();
        //生成一个[1，100]之间的随机数字。
        int resultSize = (int) (Math.random()*100) + 1;
        //产生结果
        for(int i = 0; i< resultSize; i++){
            //随机数
            result.add((int) (Math.random()*100));
        }
        //模拟耗时
        long time = resultSize * 100;
        Thread.sleep(time);
        System.out.println(name + " end.");
        System.out.println(name + " 耗时：" + time + "ms；" + "结果集大小：" + resultSize);
        return result;
    }

}
