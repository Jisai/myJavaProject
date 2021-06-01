package com.songj.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassNamee: Topic_560   https://leetcode-cn.com/problems/subarray-sum-equals-k/
 * @Description: 和为K的子数组
 *
 * @Author: Scott S
 * @Date: 2021-05-29 07:26
 * @Version: 1.0
 **/
public class Topic_560 {


    public static void main(String[] args) {
        Topic_560 topic560 = new Topic_560();
        int[] nums1 = {1,1,1};
        int k1 = 2;
        //预期结果 2。
        System.out.println(topic560.subarraySum(nums1, k1));
        int[] nums2 = {1,-1,0};
        int k2 = 0;
        //预期结果 3。
        System.out.println(topic560.subarraySum2(nums2, k2));
    }

    /**
     * @Description: 枚举
     * 时间复杂度：O(n^2)，其中 n 为数组的长度。枚举子数组开头和结尾需要 O(n^2) 的时间，
     * 其中求和需要 O(1)的时间复杂度，因此总时间复杂度为 O(n^2)。
     *
     * 空间复杂度：O(1)。只需要常数空间存放若干变量。
     */
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        for(int end = 0; end < nums.length;  end ++){
            int sum = 0;
            for(int start = end; start >= 0; start --){
                sum += nums[start];
                if(sum == k){
                    count ++;
                }
            }
        }
        return count;
    }

    /**
     * @Description: 前缀和 + 哈希表优化
     * pre[i]=pre[i−1]+nums[i]
     * pre[i]−pre[j−1]==k
     * pre[j−1]==pre[i]−k
     *
     * 时间复杂度：O(n)，其中 n 为数组的长度。我们遍历数组的时间复杂度为 O(n)，
     * 中间利用哈希表查询删除的复杂度均为 O(1)，因此总时间复杂度为 O(n)。
     *
     * 空间复杂度：O(n)，其中 n 为数组的长度。哈希表在最坏情况下可能有 n 个不同的键值，因此需要 O(n)的空间复杂度。
     */
    public int subarraySum2(int[] nums, int k) {
        int count = 0, pre = 0;
        HashMap < Integer, Integer > mp = new HashMap < > ();
        mp.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (mp.containsKey(pre - k)) {
                count += mp.get(pre - k);
            }
            mp.put(pre, mp.getOrDefault(pre, 0) + 1);
        }
        return count;
    }


}
