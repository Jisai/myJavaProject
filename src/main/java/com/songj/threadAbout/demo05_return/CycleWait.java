package com.songj.threadAbout.demo05_return;

/**
 * @ClassNamee: CycleWait
 * @Description: 获取线程返回值 - 方式1 - 主线程循环等待
 * @Author: Scott S
 * @Date: 2021-05-20 12:14
 * @Version: 1.0
 **/
public class CycleWait implements Runnable {
    private String value;
    @Override
    public void run() {
        System.out.println("The task is ready for execution...");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        value = "我是返回结果。";
        System.out.println("Task execution completed...");
    }

    public static void main(String[] args) throws Exception{
        CycleWait c = new CycleWait();
        Thread t = new Thread(c);
        t.start();
        // 循环等待
        while (c.value == null){
            Thread.sleep(100);
        }
        //或者 使用join
//        t.join();

        System.out.println("执行结果：" + c.value);
    }
}
