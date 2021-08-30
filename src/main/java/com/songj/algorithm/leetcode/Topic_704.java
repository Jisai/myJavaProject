package com.songj.algorithm.leetcode;

/**
 * @ClassNamee: Topic_704   https://leetcode-cn.com/problems/binary-search/
 * @Description:    二分查找
 * @Author: Scott S
 * @Date: 2021-07-15 19:25
 * @Version: 1.0
 **/
public class Topic_704 {




    public int search(int[] nums, int target) {
        int pivot, left = 0, right = nums.length - 1;
        while (left <= right) {
            pivot = left + (right - left) / 2;
            if (nums[pivot] == target) return pivot;
            if (target < nums[pivot]) right = pivot - 1;
            else left = pivot + 1;
        }
        return -1;
    }

}
