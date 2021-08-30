package com.songj.algorithm.leetcode;

import com.songj.bean.ListNode;

/**
 * @ClassNamee: Topic_21    https://leetcode-cn.com/problems/merge-two-sorted-lists/
 * @Description:    合并两个有序链表
 * @Author: Scott S
 * @Date: 2021-07-23 11:09
 * @Version: 1.0
 **/
public class Topic_21 {

    public static void main(String[] args) {
        ListNode L1 = new ListNode(1);
        L1.next =  new ListNode(2);
        L1.next.next = new ListNode();

        ListNode L2 = new ListNode(1);
        L2.next = new ListNode(3);
        L2.next.next = new ListNode(4);
        L2.next.next.next = new ListNode();

        Topic_21 solution6 = new Topic_21();
        solution6.mergeTwoLists(L1, L2);
    }


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        else if (l2 == null) {
            return l1;
        }
        else if (l1.val < l2.val) {
            return new ListNode(l1.getVal(), mergeTwoLists(l1.getNext(), l2));
        }
        else {
            return new ListNode(l2.getVal(), mergeTwoLists(l1, l2.getNext()));
        }
    }

    /**
     * 方法一：递归
     */
    public ListNode mergeTwoLists_2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }

    }

    /**
     * 方法二：迭代
     */
    public ListNode mergeTwoLists_3(ListNode l1, ListNode l2) {
        ListNode prehead = new ListNode(-1);

        ListNode prev = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        // 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
        prev.next = l1 == null ? l2 : l1;

        return prehead.next;
    }

}
