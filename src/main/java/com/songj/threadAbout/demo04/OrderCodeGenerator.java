package com.songj.threadAbout.demo04;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName: OrderCodeGenerator
 * @Description: 订单编号生成
 * @Author: Scott S
 * @Date: 2019/5/25 14:38
 * @Version: 1.0
 **/
public class OrderCodeGenerator {

    //自增长序列
    private long i = 0;

    public String getOrderCode(){
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss-");
        return sdf.format(now) + ++i;
    }

    public static void main(String[] args) {
        OrderCodeGenerator ong = new OrderCodeGenerator();
        for (int i = 0; i < 10 ; i++){
            System.out.println(ong.getOrderCode());
        }
    }


}
