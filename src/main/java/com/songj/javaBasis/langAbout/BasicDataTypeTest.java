package com.songj.javaBasis.langAbout;

import org.junit.Test;

/**
 * @ClassNamee: BasicDataTypeTest
 * @Description:    基本数据类型
 * @Author: Scott S
 * @Date: 2021-06-08 10:31
 * @Version: 1.0
 **/
public class BasicDataTypeTest {


    @Test
    public void typeConversion(){
        double double_a = 1.01;
        double double_b;
        int int_a = 1;
        int int_b;
        int_b = (int) double_a;
        double_b = int_a;
        System.out.println( int_b);
        System.out.println( double_b);

        Boolean boolean_a = false;
        Boolean boolean_b;
        Integer int_c = 3;
//        boolean_b = int_c + boolean_a;

    }
}
