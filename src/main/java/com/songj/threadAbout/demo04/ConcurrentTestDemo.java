package com.songj.threadAbout.demo04;

import org.junit.Test;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @ClassName: ConcurrentTestDemo
 * @Description: 并发测试demo
 * @Author: Scott S
 * @Date: 2019/5/25 15:42
 * @Version: 1.0
 **/
public class ConcurrentTestDemo {

    private AtomicBoolean wait = new AtomicBoolean();

    @Test
    public void testConcurrent01(){
    //并发数
        int currency = 10;
        //循环屏障
        CyclicBarrier cb = new CyclicBarrier(currency);
        OrderService orderService = new OrderServiceImpl();
        //多线程模拟高并发
        for(int i = 0; i< currency; i++){
            synchronized (this.wait){
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println(Thread.currentThread().getName() + "- - - - - - - 我准备好 - - - - - - - ");
                        //等待一起出发
                        try {
                            cb.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        //调用创建订单服务
                        orderService.createOrder();
                    }
                }).start();
            }

        }
    }



    @Test
    public void testConcurrent02(){
        //并发数
        int currency = 10;
        //循环屏障
        CyclicBarrier cb = new CyclicBarrier(currency);

        //多线程模拟高并发
        for(int i = 0; i< currency; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    //模拟分布式集群场景
                    OrderService orderService = new OrderServiceImplWithLock();
                    System.out.println(Thread.currentThread().getName() + "- - - - - - - 我准备好 - - - - - - - ");
                    //等待一起出发
                    try {
                        cb.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //调用创建订单服务
                    orderService.createOrder();
                }
            }).start();
        }
    }

}
