package com.songj.numCalculation;

import java.math.BigDecimal;

public class BigDecimalTest {

    public static void main(String[] args) {
        BigDecimalTest object = new BigDecimalTest();
        object.test01("1","3");
    }


    /**
     * 【商=被除数.devide(除数，保留小数位数，精确方法) 】
     * ROUND_CEILING: 舍位时往正无穷方向移动 1.1-> 2 1.5-> 2 1.8-> 2 -1.1-> -1 -1.5-> -1 -1.8-> -1
     * ROUND_DOWN:向0的方向移动1.1-> 1 1.5-> 1 1.8-> 1 -1.1-> -1 -1.5-> -1 -1.8> -1
     * ROUND_FLOOR:与CEILING相反，往负无穷 1.1-> 1 1.5-> 1 1.8-> 1 -1.1-> -2 -1.5-> -2 -1.8-> -2
     * ROUND_HALF_DOWN:以5为分界线，或曰五舍六入1.5-> 1 1.6-> 1 -1.5-> -1 -1.6-> -2
     * ROUND_HALF_EVEN:同样以5为分界线，如果是5，则前一位变偶数1.15-> 1.2 1.16-> 1.2 1.25-> 1.2 1.26-> 1.3
     * ROUND_HALF_UP:最常见的四舍五入
     * ROUND_UNNECESSARY:无需舍位
     * ROUND_UP:与ROUND_DOWN，远离0的方向1.1-> 2 1.5-> 2 1.8-> 2 -1.1-> -2 -1.5-> -2 -1.8-> -2
     *
     */
    private void test01(String v1, String v2){
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        System.out.println(b1.divide(b2, 2, BigDecimal.ROUND_HALF_UP));;

    }

}
