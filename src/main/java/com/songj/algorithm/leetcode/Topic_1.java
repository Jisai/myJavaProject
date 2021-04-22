package com.songj.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassNamee: Topic_1
 * @Description: 两数之和
 **/
public class Topic_1 {


    public static void main(String[] args) {
        int[] nums = {1,3,8,6,45,12,64,9};
        int target = 73;
        method_01(nums, target);
        method_02(nums, target);
        method_03(nums, target);

    }


    /**
     * 【暴力法】-- 官方
     * 暴力法很简单，遍历每个元素 x，并查找是否存在一个值与 target - x 相等的目标元素。
     *
     * 复杂度分析：
     * 时间复杂度：O(n^2);
     * 对于每个元素，我们试图通过遍历数组的其余部分来寻找它所对应的目标元素，这将耗费 O(n) 的时间。因此时间复杂度为 O(n^2);
     * 空间复杂度：O(1)。
     *
     */
    public static int[] method_01(int[] nums, int target){
        for(int i = 0; i < nums.length -1; i ++){
            for(int j = i+1; j < nums.length; j ++){
                if(nums[j] == target - nums[i]){
                    System.out.println("符合条件的下标是 " + i + " 和 " + j);
                    return new int[]{i,j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * 【两遍哈希表】-- 官方
     * 复杂度分析：
     * 时间复杂度：O(n)，
     * 我们把包含有 n个元素的列表遍历两次。由于哈希表将查找时间缩短到 O(1) ，所以时间复杂度为 O(n)。
     *
     * 空间复杂度：O(n)，
     * 所需的额外空间取决于哈希表中存储的元素数量，该表中存储了 n 个元素。
     */
    public static int[] method_02(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<>();
        for(int i =0; i < nums.length; i++){
            map.put(nums[i], i);
        }
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(target - nums[i])){
                System.out.println("符合条件的下标是 " + i + " 和 " + map.get(target - nums[i]));
                return new int[]{i, map.get(target - nums[i])};
            }
        }

        throw new IllegalArgumentException("No two sum solution");
    }


    /**
     * 【一遍哈希表】-- 官方
     * 复杂度分析：
     * 时间复杂度：O(n)，
     * 我们只遍历了包含有 n 个元素的列表一次。在表中进行的每次查找只花费 O(1)的时间。
     *
     * 空间复杂度：O(n)，
     * 所需的额外空间取决于哈希表中存储的元素数量，该表最多需要存储 n 个元素。
     */
    public static int[] method_03(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(target - nums[i])){
                System.out.println("符合条件的下标是 " + i + " 和 " + map.get(target - nums[i]));
                return new int[]{i, map.get(target - nums[i])};
            }
            map.put(nums[i], i);
        }

        throw new IllegalArgumentException("No two sum solution");
    }
}
