package com.songj.algorithm.leetcode;

/**
 * @ClassNamee: Topic_189   https://leetcode-cn.com/problems/rotate-array/
 * @Description:    旋转数组
 * @Author: Scott S
 * @Date: 2021-07-15 19:40
 * @Version: 1.0
 **/
public class Topic_189 {



    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start += 1;
            end -= 1;
        }
    }

}
