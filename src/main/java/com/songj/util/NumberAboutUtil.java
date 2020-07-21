package com.songj.util;

import java.util.Random;

/**
 * 数值相关的工具类
 */
public class NumberAboutUtil {


    /**
     * 获取随机正整数
     * @param maxInt 获取的最大整数值
     * @return
     */
    public static int getARandomInteger(int maxInt){
        Random random = new Random();
        return random.nextInt(maxInt) + 1;
    }


}
