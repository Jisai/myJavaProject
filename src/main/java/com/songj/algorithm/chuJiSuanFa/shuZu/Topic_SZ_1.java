package com.songj.algorithm.chuJiSuanFa.shuZu;

/**
 * @ClassNamee: Topic_SZ_1  删除排序数组中的重复项
 * @Description:    https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2gy9m/
 * @Author: Scott S
 * @Date: 2022-03-09 09:35
 * @Version: 1.0
 **/
public class Topic_SZ_1 {

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,2};
        System.out.println(new Topic_SZ_1().removeDuplicates(nums));
    }


    // 双指针解决
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int l = 0;
        for(int r = 1; r < nums.length; r++){
            if(nums[l] < nums[r]){
                l++;
                nums[l] = nums[r];
            }
        }
        return l+1;
    }

}
