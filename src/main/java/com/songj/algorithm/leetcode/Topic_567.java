package com.songj.algorithm.leetcode;


import com.alibaba.fastjson.JSON;
import com.songj.bean.ListNode;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/** https://leetcode-cn.com/problems/permutation-in-string/
 *  字符串的排列
 */
public class Topic_567 {


    public static void main(String[] args) {
        String s1 = "abcfhdab";
        String s2 = s1.substring(0, s1.length());
        System.out.println(s2);
    }

    /**方法一：滑动窗口
     * 由于排列不会改变字符串中每个字符的个数，
     * 所以只有当两个字符串每个字符的个数均相等时，一个字符串才是另一个字符串的排列。
     * 根据这一性质，记 s_1的长度为 n，
     * 我们可以遍历 s_2中的每个长度为 n 的子串，
     * 判断子串和 s_1中每个字符的个数是否相等，
     * 若相等则说明该子串是 s_1的一个排列。
     */
    public boolean checkInclusion(String s1, String s2) {
        boolean result = false;

        int l1 = s1.length();
        int l2 = s2.length();
        if(l1 > l2){
            return false;
        }
        int[] a1 = new int[26];
        int[] a2 = new int[26];
        for(int i =0; i < l1; i++){
            a1[s1.charAt(i) - 'a'] ++;
            a2[s2.charAt(i) - 'a'] ++;
        }
        if(Arrays.equals(a1, a2)){
            return true;
        }
        for(int i = l1; i < l2; i++){
            a2[s2.charAt(i) - 'a'] ++;
            a1[s2.charAt(i - l1) - 'a'] --;
            if(Arrays.equals(a1, a2)){
                return true;
            }
        }
        return result;
    }

    private Map<Character, Integer> getMap(String s){
        Map<Character, Integer> map = new HashMap<>();
        if(s==null || s.length() == 0){
           return map;
        }
        for(int i = 0; i < s.length(); i++){
            if(map.keySet().contains(s.charAt(i))){
                map.put(s.charAt(i), (map.get(s.charAt(i)) + 1));
            }else{
                map.put(s.charAt(i), 1);
            }
        }
        return map;
    }



}
