package com.songj.collectionAbout;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: ArrayTest
 * @Description: TODO
 * @Author: Scott S
 * @Date: 2019/5/15 17:53
 * @Version: 1.0
 **/
public class ArrayTest {




    /**
     * 打印数组
     **/
    @Test
    public void printArray(){
        Integer[] paramArr = new Integer[]{1,2,3,4,5,6,7,8,9,10};
        //方法一：使用循环打印。
        StringBuffer strBuffer = new StringBuffer();
        for(int i = 0; i< paramArr.length; i++) {
            if(i > 0) {
                strBuffer.append(", ");
            }
            strBuffer.append(paramArr[i]);
        }
        System.out.println(strBuffer);
        //方法二：使用 Arrays.toString() 打印。
        System.out.println(Arrays.toString(paramArr));
        //方法三：使用 JDK8 的  java.util.Arrays.stream()  打印。
        Arrays.stream(paramArr).forEach(System.out::println);
        //方法四：使用 Arrays.deepToString() 方法打印。如果数组中有其它数组，即多维数组，也会用同样的方法深度显示。
        System.out.println(Arrays.deepToString(paramArr));
        //方法五：使用 JDK 8 的 Stream.flatMap() 打印。
        Arrays.stream(paramArr).forEach(System.out::println);
    }

    @Test
    public void arrayToList(){
        String testString = ",a,b,c,d,e,f";
        String[] arr = testString.split(",");
        System.out.println("arr >> " + JSON.toJSONString(arr));
        List<String> list = Arrays.asList(testString.split(","));
        System.out.println("list >> " + list.toString());
    }













}
