package com.songj.langAbout;

import java.math.BigDecimal;

/**
 * @ClassName: LangTest
 * @Description: TODO
 * @Author: Scott S
 * @Date: 2018-07-18 16:00
 * @Version: 1.0
 */
public class LangTest {

    public static void main(String[] args) {
        LangTest langTest = new LangTest();
//        langTest.equalTest();
        langTest.test02();
//        langTest.isAccordWithEffectCutTimeOverLap(1535904000000L,1538582399000L,1538582399000L,1541001599000L);
//        langTest.isAccordWithEffectCutTimeOverLap(1535904000000L,1538582399000L,1535904000000L,1538582399000L);


    }


    /**
     *
     */
    public void equalTest(){
        Float a = 10.00f;
        Double b = 10.01;
        Double c = 10.00;
        BigDecimal data1 = new BigDecimal(a);
        BigDecimal data2 = new BigDecimal(b);
        BigDecimal data3 = new BigDecimal(c);
        System.out.println(data1.compareTo(data3));
        System.out.println(data2.compareTo(data3));

    }

    /**
     * 10L.compareTo(10L) = 0
     * 9L.compareTo(10L) = -1
     * 11L.compareTo(10L) = 1
     */
    public void test02(){
        Long rightValidDate = 100000000000L;
        Long rightInValidDate = 100000000001L;
        Long leftValidDate= 100000000000L;
        Long leftInValidDate= 100001L;
        System.out.println(rightValidDate.compareTo(leftValidDate));
        System.out.println(leftValidDate.compareTo(rightInValidDate));
        System.out.println(rightInValidDate.compareTo(leftInValidDate));
        System.out.println(rightValidDate.longValue() == leftValidDate.longValue());
        System.out.println(rightValidDate.equals(leftValidDate));

    }



    private void isAccordWithEffectCutTimeOverLap(Long leftValidDate, Long leftInValidDate, Long rightValidDate, Long rightInValidDate){
        Integer result = 1;

        if(rightValidDate.compareTo(leftValidDate) == -1 && leftValidDate.compareTo(rightInValidDate) != 1 && rightInValidDate.compareTo(leftInValidDate) != 1){
            //A＜C≤B 且 B≤D
            result = 1;
        }else if(rightValidDate.compareTo(leftValidDate) == 0 && rightInValidDate.compareTo(leftInValidDate) != 1){
            //A=C且 B≤D
            result = 2;
        }else if(rightInValidDate.compareTo(leftValidDate) == -1){
            //B＜C
            result = 3;
        }else if(leftValidDate.compareTo(rightValidDate) == -1){
            //C＜A
            result = 4;
        }else {
            result = 5;
        }

        System.out.println(result);

    }


}
