package com.songj.algorithm.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * @ClassNamee: Topic_217   https://leetcode-cn.com/problems/contains-duplicate/
 * @Description:    存在重复元素
 * @Author: Scott S
 * @Date: 2021-07-20 17:46
 * @Version: 1.0
 **/
public class Topic_217 {



    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }

    public boolean containsDuplicate_2(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int x : nums) {
            if (!set.add(x)) {
                return true;
            }
        }
        return false;
    }

    public boolean containsDuplicate_3(int[] nums) {
        return IntStream.of(nums).distinct().count() != nums.length;
    }

}
