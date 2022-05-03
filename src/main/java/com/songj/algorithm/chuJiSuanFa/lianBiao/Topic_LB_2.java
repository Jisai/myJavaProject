package com.songj.algorithm.chuJiSuanFa.lianBiao;

import com.songj.model.po.ListNode;

/**
 * @ClassNamee: Topic_LB_2
 * @Description:    删除链表的倒数第N个节点
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xn2925/
 **/
public class Topic_LB_2 {

    /**
     * @Description: 双指针
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;
        for(int i = 0; i < n; i++){
            fast = fast.next;
        }
        if(fast == null ){
            return head.next;
        }
        while (fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;

        return head;
    }

}
