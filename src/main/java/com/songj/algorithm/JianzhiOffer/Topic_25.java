package com.songj.algorithm.JianzhiOffer;

import com.songj.model.po.ListNode;

/**
 * @ClassNamee: Topic_25
 * @Description: 合并两个排序的链表
 * @Author: Scott S
 * @Date: 2020-11-29 21:31
 * @Version: 1.0
 **/
public class Topic_25 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dum = new ListNode(0), cur = dum;
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            }
            else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 != null ? l1 : l2;
        return dum.next;
    }


}
