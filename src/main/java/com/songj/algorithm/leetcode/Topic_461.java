package com.songj.algorithm.leetcode;

/**
 * @ClassNamee: Topic_461   https://leetcode-cn.com/problems/hamming-distance/
 * @Description: 汉明距离
 * @Author: Scott S
 * @Date: 2021-05-29 11:46
 * @Version: 1.0
 **/
public class Topic_461 {

    public static void main(String[] args) {

    }

    /**
     * @Description: 内置位计数功能
     * 时间复杂度：O(1)。不同语言的实现方法不一，我们可以近似认为其时间复杂度为 O(1)。
     *
     * 空间复杂度：O(1)。
     */
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }

    /**
     * @Description: 移位实现位计数
     *时间复杂度：O(log C)，其中 C是元素的数据范围，在本题中 log C=log 2^{31} =31。
     *
     * 空间复杂度：O(1)。
     */
    public int hammingDistance2(int x, int y) {
        int s = x ^ y, ret = 0;
        while (s != 0) {
            ret += s & 1;
            s >>= 1;
        }
        return ret;
    }


}
