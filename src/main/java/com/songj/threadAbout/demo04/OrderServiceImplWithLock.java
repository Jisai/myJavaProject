package com.songj.threadAbout.demo04;

import org.junit.Test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName: OrderServiceImplWithLock
 * @Description: 带锁的订单服务实现
 * @Author: Scott S
 * @Date: 2019/5/27 9:05
 * @Version: 1.0
 **/
public class OrderServiceImplWithLock implements OrderService {

    private Lock lock = new ReentrantLock();

    private OrderCodeGenerator ocg = new OrderCodeGenerator();

    @Test
    @Override
    public void createOrder(){
        String orderCode = null;

        try {
            lock.lock();
            //获取订单号
            orderCode = ocg.getOrderCode();
        } finally {
            lock.unlock();
        }
        System.out.println(Thread.currentThread().getName() + " = = = = = = = = = = = > " + orderCode);
        //生成业务代码 TODO 此处省略若干代码

    }







}
