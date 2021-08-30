package com.songj.algorithm.leetcode;

/**
 * @ClassNamee: Topic_53    https://leetcode-cn.com/problems/maximum-subarray/
 * @Description:    最大子序和
 * @Author: Scott S
 * @Date: 2021-07-20 17:48
 * @Version: 1.0
 **/
public class Topic_53 {

    /**
     * 贪心
     * 若当前指针所指元素的和小于当前元素， 则丢弃当前元素之前的数列。
     */
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int sum = nums[0];
        if(nums.length > 1){
            for(int i = 1; i < nums.length; i++){
                sum = Math.max(sum+nums[i], nums[i]);
                maxSum = Math.max(sum, maxSum);
            }
        }
        return maxSum;
    }

    /**
     * 动态规划
     * 若前一个元素大于零，则将其加到当前元素上。
     */
    public int maxSubArray_2(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }

}
