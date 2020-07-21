package com.songj.threadAbout.demo04;

/**
 * @ClassName: OrderServiceImpl
 * @Description: 订单服务 实现
 * @Author: Scott S
 * @Date: 2019/5/25 15:47
 * @Version: 1.0
 **/
public class OrderServiceImpl implements OrderService {

    private OrderCodeGenerator ocg = new OrderCodeGenerator();

    //获取订单接口
    @Override
    public void createOrder(){
        //获取订单号
        String orderCode = ocg.getOrderCode();
        System.out.println(Thread.currentThread().getName() + " ================>" + orderCode);
        //生成业务代码 TODO 此处省略若干代码


    }
}
