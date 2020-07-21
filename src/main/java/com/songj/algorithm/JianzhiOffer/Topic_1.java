package com.songj.algorithm.JianzhiOffer;

import org.junit.Test;

import java.util.Arrays;

/**
 * @ClassNamee: Topic_1
 * @Description: 在一个二维数组中（每个一维数组的长度相同），
 * 每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * @Author: Scott S
 * @Date: 2020-03-28 16:30
 * @Version: 1.0
 **/
public class Topic_1 {

    public static void main(String[] args) {
        int[][] array ={
                {1,2,3,4,5,6},
                {7,8,9,10,11,12},
                {13,14,15,16,17,18},
                {19,20,21,22,23,24}
        };
        int target = 24;
        System.out.println("method1 = " + method1(target, array));
        System.out.println("method2 = " + method2(target, array));
        System.out.println("method3 = " + method3(target, array));
    }

    @Test
    public void test(){
        int[][] array = {{1,2,3},{1},{2,3},{},{2,3,4}};
        System.out.println("array.length = " + array.length);
    }

    /**
     * @Description: 暴力法
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     */
    public static boolean method1(int target, int[][] array){
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array[i].length; j++){
                if(array[i][j] == target){
                    return true;
                }
            }
        }
        return false;
    }
    
    
    /**
     * @Description: 从左下找
     * 利用该二维数组的性质：
     * 每一行都按照从左到右递增的顺序排序，
     * 每一列都按照从上到下递增的顺序排序
     * 改变个说法，即对于左下角的值 m，m 是该行最小的数，是该列最大的数
     * 每次将 m 和目标值 target 比较：
     *
     * 当 m < target，由于 m 已经是该行最大的元素，想要更大只有从列考虑，取值右移一位
     * 当 m > target，由于 m 已经是该列最小的元素，想要更小只有从行考虑，取值上移一位
     * 当 m = target，找到该值，返回 true
     * 用某行最小或某列最大与 target 比较，每次可剔除一整行或一整列
     *
     * 时间复杂度：O(行高 + 列宽)O(行高+列宽)
     * 空间复杂度：O(1)O(1)
     */
    public static boolean method2(int target, int[][] array){
        int rows = array.length;
        if(rows == 0){return false;}
        int cols = array[0].length;
        if(cols == 0){return false;}

        int row = rows - 1;
        int col = 0;
        while (rows >= 0 && col < cols){

            if(array[row][col] > target){
                row --;
            }else if (array[row][col] < target){
                col ++;
            }else {
                return true;
            }
        }
        return false;
    }

    /** 从右上找
     * @Description: 和从左下找道理一样，都是因为每次判断都能剔除一整行或一整列
     * 时间复杂度：O(行高 + 列宽)O(行高+列宽)
     * 空间复杂度：O(1)O(1)
     */
    public static boolean method3(int target, int[][] array){
        int rows = array.length;
        if(rows == 0){return false;}
        int cols = array[0].length;
        if(cols == 0){return false;}

        int row = 0;
        int col = cols -1;
        while (row < rows && col >=0){

            if(array[row][col] > target){
                col --;
            }else if(array[row][col] < target){
                row ++;
            }else{
                return true;
            }
        }
        return false;
    }


}
