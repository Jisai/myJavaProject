package com.songj.algorithm.leetcode;


import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @ClassNamee: Topic_3
 * @Description: 无重复字符的最长子串
 * @Author: Scott S
 * @Date: 2020-08-06 18:31
 * @Version: 1.0
 **/
public class Topic_3 {

    public static void main(String[] args) {
        //测试用例为：1. 空字符串；2. 都是一个字符的字符串；3. 随机字符串。
//        String str = "abacbcbb";
//        String str = "abcdde";
        String str = " ";
        System.out.println(method_1(str));;
    }


    /**
     * @Des: 方法一：滑动窗口 -- 官方
     * 1. 左指针 i , 右指针 rk，初始位置左指针位置在字符串头部，右指针位置在左指针位置前一位；
     * 2.1 依次移动右指针位置，当遇到重复字符，右指针停止移动；
     * 2.2 再次移动左指针位置到下个字符位置，右指针保持位置不变；
     * 2.3 当左指针位置超过右指针位置时，开始重复2.1、2.2 步骤，直至左指针位置移动到字符串尾部。
     * 3. 符合题目要求的字符串为 [左,右) 指针之间的字符串。
     */
    private static int method_1(String s){
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
                System.out.println(">> i=" + i + " ans=" + ans + " rk=" + rk + " occ=" + JSON.toJSONString(occ));
            }
            System.out.println("> i=" + i + " ans=" + ans + " rk=" + rk + " occ=" + JSON.toJSONString(occ));
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }

    private static int method_2(String s){
        if (s.length()==0){ return 0;}
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        int left = 0;
        for(int i = 0; i < s.length(); i ++){
            if(map.containsKey(s.charAt(i))){
                left = Math.max(left,map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-left+1);
        }
        return max;

    }
}
