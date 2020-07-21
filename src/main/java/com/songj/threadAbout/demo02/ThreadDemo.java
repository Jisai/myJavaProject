package com.songj.threadAbout.demo02;

import org.junit.Test;

/**
 * @ClassName: ThreadTest01
 * @Description: synchronized和volatile的使用方法以及区别
 * @Author: Scott S
 * @Date: 2019/6/24 16:56
 * @Version: 1.0
 **/
public class ThreadDemo {


    @Test
    public void threadRun01(){
        final Counter01 counter = new Counter01();
        for (int i = 0; i < 1000; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    counter.inc();
                }
            }).start();
        }
        System.out.println(counter);
    }

    @Test
    public void threadRun02(){
        final Counter02 counter = new Counter02();
        for (int i = 0; i < 1000; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    counter.inc();
                }
            }).start();
        }
        System.out.println(counter);
    }

}
