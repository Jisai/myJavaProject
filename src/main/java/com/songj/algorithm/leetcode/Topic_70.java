package com.songj.algorithm.leetcode;

import org.junit.Test;

/**
 * @ClassNamee: Topic_70
 * @Description:
 * @Author: Scott S
 * @Date: 2022-02-09 15:37
 * @Version: 1.0
 **/
public class Topic_70 {


    @Test
    public void test(){
        System.out.println("1: " + climbStairs(45));
        System.out.println("2: " + climbStairs2(45));
    }


    public int climbStairs(int n) {
        int[] num = new int[n+1];
        if(n>=1){
            num[1] = 1;
        }
        if(n>=2){
            num[2] = 2;
        }
        for(int i = 3; i <=n; i++){
            num[i] = num[i-1] + num[i-2];
        }
        return num[n];
    }


    public int climbStairs2(int n) {
        if(n==1){
            return 1;
        }else if(n==2){
            return  2;
        }else{
            return  climbStairs2(n-1) + climbStairs2(n-2);
        }
    }


}
