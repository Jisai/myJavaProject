package com.songj.algorithm.leetcode;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 * @ClassNamee: Topic_5
 * @Description: 最长回文子串【回文的意思是正着念和倒着念一样，如：上海自来水来自海上】
 *     给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *     示例 1：
 *     输入: "babad"
 *     输出: "bab"
 *     注意: "aba" 也是一个有效答案。
 *     示例 2：
 *     输入: "cbbd"
 *     输出: "bb"
 **/
public class Topic_5 {

    public static void main(String[] args) {
//        String param1 = "a";
//        System.out.println("1 =" + method_1(param1));
//        String param2 = "babad";
//        System.out.println("2 =" + method_1(param2));
//        String param3 = "cbbd";
//        System.out.println("3 =" + method_1(param3));
        String param4 = "abcda";
        System.out.println("4 =" + method_1(param4));
    }

    public static String method_1(String param){

        return "";
    }

    public static String method_2(String param){
        String result = "";

        return result;
    }


    @Test
    public void test(){
        String[] chArr = {"a", "b", "c", "b", "d"};
        String param = "cbcbd";
        System.out.println("sub =" + param.substring(1, param.length()));
        StringBuilder sb = new StringBuilder();
        System.out.println(sb.indexOf("a"));
        System.out.println("|"+ sb+"|");
        sb = new StringBuilder();
        System.out.println("|"+ sb+"|");
    }

}
