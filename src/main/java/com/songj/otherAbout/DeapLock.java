package com.songj.otherAbout;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName: DeapLock
 * @BelongPackage: com.songj.otherAbout
 * @Description: 死锁学习
 * 参考：https://juejin.cn/post/6844904100488806413
 * @Author: Jisai
 * @Date: 2021/1/18 下午3:11
 * @Version: v1.0
 */
public class DeapLock {

    private static Object lockA = new Object();
    private static Object lockB = new Object();

    public void deapLock() {
        Thread theadA = new Thread(() -> {
            synchronized (lockA){
                System.out.println(Thread.currentThread().getName() + "获取 lockA 成功。");
                try {
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println(Thread.currentThread().getName() + "尝试获取 lockB。");
                    synchronized (lockB){
                        System.out.println(Thread.currentThread().getName() + "获取 lockB 成功。");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread theadB = new Thread(() -> {
            synchronized (lockB){
                System.out.println(Thread.currentThread().getName() + "获取 lockB 成功。");
                try {
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println(Thread.currentThread().getName() + "尝试获取 lockA。");
                    synchronized (lockA){
                        System.out.println(Thread.currentThread().getName() + "获取 lockA 成功。");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        theadA.start();
        theadB.start();
    }

    public static void main(String[] args) {
        DeapLock deapLock = new DeapLock();
        deapLock.deapLock();
    }
}
