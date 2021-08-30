package com.songj.algorithm.leetcode;

/**
 * @ClassNamee: Topic_35    https://leetcode-cn.com/problems/search-insert-position/solution/sou-suo-cha-ru-wei-zhi-by-leetcode-solution/
 * @Description:    搜索插入位置
 * @Author: Scott S
 * @Date: 2021-07-15 19:34
 * @Version: 1.0
 **/
public class Topic_35 {

    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1, ans = n;
        while (left <= right) {
            int mid = ((right - left) >> 1) + left;
            if (target <= nums[mid]) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    public int searchInsert2(int[] nums, int target) {
        int left = 0;
        int right = nums.length -1;
        while(right >= left){
            int mid = left + ((right - left)>>1);
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] > target){
                right = mid -1;
            }else{
                left = mid +1;
            }
        }
        return left;
    }
}
