package com.songj.algorithm.leetcode;

/**
 * @ClassNamee: Topic_283   https://leetcode-cn.com/problems/move-zeroes/
 * @Description:    移动零
 * @Author: Scott S
 * @Date: 2021-07-16 19:08
 * @Version: 1.0
 **/
public class Topic_283 {


    /** 双指针
     *  思路及解法
     *  使用双指针，左指针指向当前已经处理好的序列的尾部，右指针指向待处理序列的头部。
     *  右指针不断向右移动，每次右指针指向非零数，则将左右指针对应的数交换，同时左指针右移。
     *  注意到以下性质：
     *  左指针左边均为非零数；
     *  右指针左边直到左指针处均为零。
     *  因此每次交换，都是将左指针的零与右指针的非零数交换，且非零数的相对顺序并未改变。
     */
    public void moveZeroes(int[] nums) {
        int n = nums.length, left = 0, right = 0;
        while (right < n) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }

    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }





    /** 【两次遍历】
     *  我们创建两个指针i和j，第一次遍历的时候指针j用来记录当前有多少非0元素。
     *  即遍历的时候每遇到一个非0元素就将其往数组左边挪，第一次遍历完后，j指针的下标就指向了最后一个非0元素下标。
     *  第二次遍历的时候，起始位置就从j开始到结束，将剩下的这段区域内的元素全部置为0。
     */
    public void moveZeroes_2(int[] nums) {
        if(nums==null) {
            return;
        }
        //第一次遍历的时候，j指针记录非0的个数，只要是非0的统统都赋给nums[j]
        int j = 0;
        for(int i=0;i<nums.length;++i) {
            if(nums[i]!=0) {
                nums[j++] = nums[i];
            }
        }
        //非0元素统计完了，剩下的都是0了
        //所以第二次遍历把末尾的元素都赋为0即可
        for(int i=j;i<nums.length;++i) {
            nums[i] = 0;
        }
    }

}
