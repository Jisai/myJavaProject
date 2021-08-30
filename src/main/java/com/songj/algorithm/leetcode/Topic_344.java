package com.songj.algorithm.leetcode;

/**
 * @ClassNamee: Topic_344   https://leetcode-cn.com/problems/reverse-string/
 * @Description:    反转字符串
 * @Author: Scott S
 * @Date: 2021-07-17 08:51
 * @Version: 1.0
 **/
public class Topic_344 {

    public void reverseString(char[] s) {
        int n = s.length;
        for (int left = 0, right = n - 1; left < right; ++left, --right) {
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
        }
    }

}
