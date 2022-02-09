package com.songj.algorithm.leetcode;

import com.songj.model.po.ListNode;

/**
 * @ClassNamee: Topic_876   https://leetcode-cn.com/problems/middle-of-the-linked-list/submissions/
 * @Description:    链表的中间结点
 * @Author: Scott S
 * @Date: 2021-07-18 08:53
 * @Version: 1.0
 **/
public class Topic_876 {


    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6};
        // int[] arr = new int[]{1, 2, 3, 4, 5};
        ListNode head = new ListNode(arr);
        Topic_876 solution = new Topic_876();
        ListNode res = solution.middleNode(head);
        System.out.println(res);
    }


    public ListNode middleNode(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

}
