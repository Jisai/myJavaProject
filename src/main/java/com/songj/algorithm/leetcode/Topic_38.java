package com.songj.algorithm.leetcode;

import org.apache.commons.lang.StringUtils;

import java.util.Arrays;
import java.util.List;

/**
 * @ClassNamee: Topic_38    外观数列
 * @Description:    https://leetcode-cn.com/problems/count-and-say/
 * @Author: Scott S
 * @Date: 2022-02-22 19:53
 * @Version: 1.0
 **/
public class Topic_38 {


    /**
     *
     1
     1,1
     2,1
     1,2,1,1
     1,1,1,2,2,1
     3,1,2,2,1,1
     1,3,1,1,2,2,2,1
     */

    public static void main(String[] args) {
        String s = new Topic_38().function(7);
        String res = StringUtils.join(Arrays.asList( s.split("")), ",");
        System.out.println(res);
    }

    public String function(int n) {
        String str = "1";
        if (n == 1) {
            return str;
        }
        for (int i = 1; i < n; i++) {
            str = app(str);
        }
        return str;
    }


    private String app(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) != s.charAt(i)) {
                sb.append(count).append(s.charAt(i - 1));
                count = 0;
            }
            count++;
        }
        sb.append(count).append(s.charAt(s.length() - 1));
        return sb.toString();
    }











}
