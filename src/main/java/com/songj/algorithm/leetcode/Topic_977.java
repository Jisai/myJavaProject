package com.songj.algorithm.leetcode;

/**
 * @ClassNamee: Topic_977   https://leetcode-cn.com/problems/squares-of-a-sorted-array/
 * @Description:    有序数组的平方
 * @Author: Scott S
 * @Date: 2021-07-15 16:23
 * @Version: 1.0
 **/
public class Topic_977 {

    public static void main(String[] args) {
        Topic_977 topic_977 = new Topic_977();

    }


    public int[] sortedSquares(int[] nums) {
        int len =  nums.length;
        int[] nums_2 = new int[len];
        int left = 0;
        int right = nums.length -1;
        len --;
        while(len>=0){
            if(nums[left] * nums[left] >= nums[right] * nums[right]){
                nums_2[len] = nums[left] * nums[left];
                left++;
            }else{
                nums_2[len] =  nums[right] * nums[right];
                right--;
            }
            len --;
        }
        return nums_2;
    }
}
