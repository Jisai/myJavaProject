package com.songj.algorithm.leetcode;

import com.songj.bean.ListNode;

/**
 * @ClassNamee: Topic_19   https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 * @Description:    删除链表的倒数第 N 个结点
 * @Author: Scott S
 * @Date: 2021-07-18 09:39
 * @Version: 1.0
 **/
public class Topic_19 {


    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode first = head;
        ListNode second = dummy;
        for(int i = 0; i < n; i++){
            first = first.next;
        }
        while(first != null){
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;

        return dummy.next;
    }

}
