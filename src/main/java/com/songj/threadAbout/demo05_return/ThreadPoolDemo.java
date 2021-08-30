package com.songj.threadAbout.demo05_return;

import java.util.concurrent.*;

/**
 * @ClassNamee: ThreadPoolDemo
 * @Description:
 * @Author: Scott S
 * @Date: 2021-05-20 15:30
 * @Version: 1.0
 **/
public class ThreadPoolDemo {

    public static void main(String[] args) {
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        Future<String> future = cachedThreadPool.submit(new MyCallable());
        if( !future.isDone()){
            System.out.println("任务未完成，请继续等待。。。");
        }
        try {
            System.out.println("执行结果：" + future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }finally {
            cachedThreadPool.shutdown();
        }
    }
}
