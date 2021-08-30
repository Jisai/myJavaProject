package com.songj.threadAbout.demo05_return;

import java.util.concurrent.Callable;

/**
 * @ClassNamee: MyCallable
 * @Description:
 * @Author: Scott S
 * @Date: 2021-05-20 12:08
 * @Version: 1.0
 **/
public class MyCallable implements Callable<String> {

    @Override
    public String call() throws Exception {
        String result = "我是返回结果。";
        System.out.println("The task is ready for execution...");
        Thread.sleep(5000);
        System.out.println("Task execution completed...");
        return result;
    }
}
