package com.songj.algorithm.chuJiSuanFa.lianBiao;

import com.songj.model.po.ListNode;

import java.util.Stack;

/**
 * @ClassNamee: Topic_LB_3
 * @Description:    反转链表
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnnhm6/
 **/
public class Topic_LB_3 {


    public ListNode reverseList1(ListNode head) {
        Stack<ListNode> stack = new Stack();
        while (head != null){
            stack.push(head);
            head = head.next;
        }
        ListNode cur =  new ListNode();
        ListNode result =  new ListNode();
        while (!stack.empty()){
            cur = stack.pop();
            cur = cur.next;
        }
        return result.next;
    }



}
