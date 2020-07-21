package com.songj.algorithm;

import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: CustomExample
 * @Description: 提供共用的自定义的参数示例
 * @Author: Scott S
 * @Date: 2019/6/26 11:34
 * @Version: 1.0
 **/
public  class CustomExample {


    /**
     * @Description: 获取[start, end] 的有序的整型List
     * @Param: [start, end]
     * @Return: java.util.List<java.lang.Integer>
     * @Author: Scott S
     * @Date: 2019/6/26 - 11:38
     **/
    public static List<Integer> getIntList(int start, int end){
        List<Integer> result = Arrays.asList();
        for(int i = start ; start <= end; i++){
            result.add(i);
        }
        return result;
    }


    /**
     * @Description: 随机获取无序的整型List
     * @Param: [size - list的大小, min - 随机数最小值, max - 随机数最大值]
     * @Return: java.util.List<java.lang.Integer>
     * @Author: Scott S
     * @Date: 2019/6/26 - 11:42
     **/
    public static List<Integer> getDisorderedIntList(int size,int min, int max){
        List<Integer> result = Arrays.asList();
        for(int i = 0 ; i <= size; i++){
            int item = (int)(min + Math.random() * max);
            result.add(item);
        }
        return result;
    }





}
