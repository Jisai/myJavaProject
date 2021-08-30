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

    @Test
    public void test(){
        int[] intArr = new int[2];
        intArr[1] = 1;
        //方法二：使用 Arrays.toString() 打印。
        System.out.println(Arrays.toString(intArr));
    }


    // Arrays 类 equals()方法
    // 使用 Arrays.equals()方法比较两个数组元素是否相等
    @Test
    public void testArraysEquals(){
        int[] arr1 = { 93,5,3,55,57 };
        int[] arr2 = { 93,5,3,55,57 };
        int[] arr3 = { 93,3,5,55,57 };
        // ==比较
        System.out.println("arr1==arr2: "+(arr1==arr2));//false
        // equals
        System.out.println("Arrays.equals(arr1,arr2): "+Arrays.equals(arr1,arr2));//true
        System.out.println("Arrays.equals(arr2,arr3): "+Arrays.equals(arr2,arr3));//false
    }

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
        String testString = "a,b,c,d,e,f";
        String[] arr = testString.split(",");
        System.out.println("arr >> " + JSON.toJSONString(arr));
        List<String> list = Arrays.asList(testString.split(","));
        System.out.println("list >> " + list.toString());
    }

    @Test
    public void arraycopy(){
        int[] arr1 = {1,2,3,4,5};
        int[] arr2 = {0,0,0,0,0,0,0};
        System.out.println(arr1.length);
        System.arraycopy(arr1, 0, arr2, 1, 3);
        System.out.println(Arrays.toString(arr2));
    }













}
