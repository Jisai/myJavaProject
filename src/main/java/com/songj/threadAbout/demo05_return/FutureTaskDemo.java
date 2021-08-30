package com.songj.threadAbout.demo05_return;

import java.util.concurrent.FutureTask;

/**
 * @ClassNamee: FutureTaskDemo
 * @Description:
 * @Author: Scott S
 * @Date: 2021-05-20 15:24
 * @Version: 1.0
 **/
public class FutureTaskDemo {

    public static void main(String[] args) throws Exception{
        FutureTask<String> task = new FutureTask<String>(new MyCallable());
        new Thread(task).start();

        if( !task.isDone()){
            System.out.println("任务未完成，请继续等待。。。");
        }
        System.out.println("执行结果：" + task.get());
    }
}
