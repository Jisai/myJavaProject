package com.songj.threadAbout.demo01.multipleThread;

/**
 * @ClassNamee: MainThreadDemo
 * @Description:  多个线程 - 主线程业务测试用例
 * @Author: Scott S
 * @Date: 2020-07-17 14:19
 * @Version: 1.0
 **/
public class MainThreadDemo {

    public static void main(String[] args) {
        System.out.println("CPU核数 = " + Runtime.getRuntime().availableProcessors());
        test1();
    }


    public static void test1(){
        //创建并运行的线程对象。【java按照自己的方式自由调度线程执行，并不是按照创建先后顺序。】
        MyRunnable_01 mr1 = new MyRunnable_01("我的线程_1");
        MyRunnable_01 mr2 = new MyRunnable_01("我的线程_2");
        MyRunnable_01 mr3 = new MyRunnable_01("我的线程_3");
        int count = 0;
        while (mr1.thread.isAlive() || mr2.thread.isAlive() || mr3.thread.isAlive()){
            ++ count;
            try {
                //模拟主线程运行状态，间隔100ms打印一次。
                Thread.sleep(100);
                System.out.println(" 第 " + count + " 次检测结果：" + mr1.thread.isAlive() + " || " +  mr2.thread.isAlive() + " || " +  mr3.thread.isAlive());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("主线程执行完毕。");
    }


}
