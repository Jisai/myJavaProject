package com.songj.algorithm.chuJiSuanFa.lianBiao;

import com.songj.model.po.ListNode;

/**
 * @ClassNamee: Topic_LB_1
 * @Description:    删除链表中的节点
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnarn7/
 **/
public class Topic_LB_1 {

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

}
