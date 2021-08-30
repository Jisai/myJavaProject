package com.songj.numCalculation;

import org.junit.Test;

/**
 * @ClassNamee: NumCalcuTest
 * @Description: 数据计算
 * @Author: Scott S
 * @Date: 2019-09-17 16:12
 * @Version: 1.0
 **/
public class NumCalcuTest {

    @Test
    public void test01(){
        int a = 2;
        int b = 2;
        int c = 3;
        int d = 4;
        //i+=1效果略相当于i=i+1(但是还是有区别)。i=1就是给i赋值为1。
        a += 1;
        //java中有=+的写法并且不报错，其效果相当于=，本人亲测，但是不知道原理。
        b =+ 1;
        System.out.println(a);
        System.out.println(b);


    }








}
