package com.songj.algorithm.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassNamee: Topic_442   https://leetcode-cn.com/problems/find-all-duplicates-in-an-array/
 * 给定一个整数数组 a，其中1 ≤ a[i] ≤ n （n为数组长度）, 其中有些元素出现两次而其他元素出现一次。
 *     找到所有出现两次的元素。
 *     你可以不用到任何额外空间并在O(n)时间复杂度内解决这个问题吗？
 *     示例：
 *     输入:
 *         [4,3,2,7,8,2,3,1]
 *      输出:
 *         [2,3]
 **/
public class Topic_442 {



    /**
     * 1. 遍历数组，假如当前数字nums[i] = x，则把下标为x-1的数字变成负数 (nums[x-1] = -nums[x-1]）。
     * 2. 继续遍历，若第二次遇到x的时候，我们去查找x-1位置的数字是否为负数，是的话则说明之前遇到过了x，把它加入答案中。
     * 这道题的核心在于，题目需要判断的是一个数字出现过1次，还是2次，
     * 这是一个二元的信息，也就是可以用一个boolean表达，
     * 但是题目要求不能使用额外内存空间，那么我们可以充分利用数组本身来存储这个二元信息，
     * 最简单的是就是把数字置成正负来表达，出现过一次还是两次。
     */
    @Test
    public void method_2() {
        //输出 [2,3]
        int[] nums = new int[]{4,3,2,7,8,2,3,1};
        List<Integer> rs = new ArrayList<>();
        for(int i=0; i < nums.length; i++) {
            int curNum = Math.abs(nums[i]);
            if(nums[curNum - 1] > 0){
                nums[curNum - 1] = -nums[curNum - 1];
            }else{
                rs.add(curNum);
            }
        }

        System.out.println(rs);
    }


}
