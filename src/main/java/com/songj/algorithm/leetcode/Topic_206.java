package com.songj.algorithm.leetcode;

import com.songj.bean.ListNode;

/**
 * @ClassNamee: Topic_206   https://leetcode-cn.com/problems/reverse-linked-list/
 * @Description:    反转链表
 * @Author: Scott S
 * @Date: 2021-07-23 11:19
 * @Version: 1.0
 **/
public class Topic_206 {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6};
        // int[] arr = new int[]{1, 2, 3, 4, 5};
        ListNode head = new ListNode(arr);
        Topic_206 topic = new Topic_206();
        ListNode res = topic.reverseList(head);
        System.out.println(res);
    }


    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

}
