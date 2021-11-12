package com.songj.algorithm.leetcode;

import com.songj.model.po.ListNode;

/**
 * @ClassNamee: Topic_18  https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof/
 * @Description:  删除链表的节点
 * @Author: Scott S
 * @Date: 2021-08-06 09:57
 * @Version: 1.0
 **/
public class Topic_18 {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6};
        // int[] arr = new int[]{1, 2, 3, 4, 5};
        ListNode head = new ListNode(arr);
        Topic_18 topic = new Topic_18();
        ListNode res = topic.deleteNode(head, 3);
        System.out.println(res);
    }


    public ListNode deleteNode(ListNode head, int val) {
        if(head.val == val) {return head.next;}
        ListNode pre = head, cur = head.next;
        while(cur != null && cur.val != val) {
            pre = cur;
            cur = cur.next;
        }
        if(cur != null) {pre.next = cur.next;}
        return head;
    }

}
