package com.songj.threadAbout.demo01.singleThread;

/**
 * @ClassNamee: MyThread01
 * @Description: 单一线程 - 我自己的线程
 * @Author: Scott S
 * @Date: 2020-07-17 18:19
 * @Version: 1.0
 **/
public class MyThread01 extends Thread {

    //构建一个新的线程
    MyThread01(String name){
        //命名线程
        super(name);
        //启动线程
        start();
    }

    @Override
    public void run(){
        System.out.println("线程-" + getName() + "启动。");
        try {
            //模拟业务方法耗时ms
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程-" + getName() + "终止。");
    }


}
