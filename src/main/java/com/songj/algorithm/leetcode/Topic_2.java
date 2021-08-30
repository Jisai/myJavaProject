package com.songj.algorithm.leetcode;


import com.alibaba.fastjson.JSON;
import com.songj.bean.ListNode;
import org.junit.Test;

/**
 * @ClassNamee: Topic_2
 * @Description: 两数相加
 **/
public class Topic_2 {

    public static void main(String[] args) {
        Integer[] l1 = {1,2,3};
        Integer[] l2 = {4,5,6,7};
        ListNode node1 = new ListNode();
        ListNode node2 = new ListNode();
        getListNode(l1, node1, 0);
        getListNode(l2, node2, 0);
        System.out.println(JSON.toJSONString(node1));
        System.out.println(JSON.toJSONString(node2));
//        ListNode addTwoNumbers = method_01(node1, node2);
//        ListNode addTwoNumbers = method_01(node1, node2);
        ListNode addTwoNumbers = addTwoNumbers(node1, node2);
        System.out.println(JSON.toJSONString(addTwoNumbers));

    }

    // {"next":{"next":{"val":3},"val":4},"val":2}
    @Test
    public void getListNode() {
        ListNode node1 = new ListNode();
        ListNode node2 = new ListNode();
        ListNode node3 = new ListNode();
        node1.val = 2;
        node1.next = node2;
        node2.val = 4;
        node2.next = node3;
        node3.val = 3;
        System.out.println(JSON.toJSONString(node1));
    }

    public static ListNode getListNode(Integer[] arr, ListNode node, int location) {
        if (arr != null && location >= arr.length) {
            return node;
        }
        int cur = arr[location];
        node.val = cur;
        location++;
        if (location < arr.length) {
            node.next = getListNode(arr, new ListNode(), location);
        }
        return node;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + carry;
            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                //将next节点设置为下一次的当前节点
                tail = tail.next;
            }
            carry = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return head;
    }


    /* -- 官方
     * 就像你在纸上计算两个数字的和那样，我们首先从最低有效位也就是列表 l1 和 l2 的表头开始相加。
     * 由于每位数字都应当处于 0…9 的范围内，我们计算两个数字的和时可能会出现 “溢出”。
     * 例如，5 + 7 = 12。在这种情况下，我们会将当前位的数值设置为 22，并将进位 carry = 1带入下一次迭代。
     * 进位 carry 必定是 0 或 1，这是因为两个数字相加（考虑到进位）可能出现的最大和为 9 + 9 + 1 = 19。
     *
     * 伪代码如下：
     *
     * 将当前结点初始化为返回列表的哑结点。
     * 将进位 carry 初始化为 0。
     * 将 p 和 q 分别初始化为列表 l1 和 l2 的头部。
     * 遍历列表 l1 和 l2 直至到达它们的尾端。
     * 将 x 设为结点 p 的值。如果 p 已经到达 l1 的末尾，则将其值设置为 0。
     * 将 y 设为结点 q 的值。如果 q 已经到达 l2 的末尾，则将其值设置为 0。
     * 设定 sum = x + y + carry。
     * 更新进位的值，carry = sum / 10。
     * 创建一个数值为 (sum mod 10) 的新结点，并将其设置为当前结点的下一个结点，然后将当前结点前进到下一个结点。
     * 同时，将 p 和 q 前进到下一个结点。
     * 检查 carry = 1是否成立，如果成立，则向返回列表追加一个含有数字 1 的新结点。
     * 返回哑结点的下一个结点。
     * 请注意，我们使用哑结点来简化代码。如果没有哑结点，则必须编写额外的条件语句来初始化表头的值。
     *
     * 请特别注意以下情况：
         测试用例	                                说明
         l1=[0,1]，l2=[0,1,2]                        当一个列表比另一个列表长时
         l1=[]，l2=[0,1]	                         当一个列表为空时，即出现空列表
         l1=[9,9]，l2=[1]                            求和运算最后可能出现额外的进位，这一点很容易被遗忘
     *
     */
    public static ListNode method_01(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) {
                p = p.next;
            }
            if (q != null) {
                q = q.next;
            }
        }
        //求和运算最后可能出现额外的进位，这一点很容易被遗忘
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

    /**
     * -- 官方
     * 将两个链表看成是相同长度的进行遍历，如果一个链表较短则在前面补 0，比如 987 + 23 = 987 + 023 = 1010。
     * 每一位计算的同时需要考虑上一位的进位问题，而当前位计算结束后同样需要更新进位值。
     * 如果两个链表全部遍历完毕后，进位值为 1，则在新链表最前方添加节点 1。
     * 小技巧：对于链表问题，返回结果为头结点时，通常需要先初始化一个预先指针 pre，该指针的下一个节点指向真正的头结点head。
     * 使用预先指针的目的在于链表初始化时无可用节点值，而且链表构造过程需要指针移动，进而会导致头指针丢失，无法返回结果。
     */
    public static ListNode method_02(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + carry;
            System.out.println("x=" + x + " y=" + y + " sum=" + sum);
            carry = sum / 10;
            sum = sum % 10;
            cur.next = new ListNode(sum);
            cur = cur.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        if (carry == 1) {
            cur.next = new ListNode(carry);
        }
        return pre.next;
    }

    /**
     * 1. 判断链表长度是否相等。
     * 2.1 长度不等，创建节点构造相等；
     * 2.2 长度相等，俩链表相加得到L3；
     * 3. 处理L3中 >10 的元素；
     * 4.1 有后继；
     * 4.2 无后继；
     */
    public static ListNode method_03(ListNode l1, ListNode l2) {
        ListNode l1_cur = l1;
        ListNode l2_cur = l2;
        ListNode l3 = new ListNode(0);
        ListNode l3_cur = null;
        int count1 = 0;
        int count2 = 0;

        while (l1_cur != null)   // 判断L1位数
        {
            count1++;
            l1_cur = l1_cur.next;
        }

        while (l2_cur != null)   // 判断L2位数
        {
            count2++;
            l2_cur = l2_cur.next;
        }

        if (count1 > count2) {
            l2_cur = l2;
            int dif = count1 - count2;
            while (l2_cur.next != null)   // travel to the last
            {
                l2_cur = l2_cur.next;
            }

            while (dif != 0) {
                ListNode lNew = new ListNode(0);
                lNew.next = null;

                l2_cur.next = lNew;
                l2_cur = l2_cur.next;
                dif--;
            }
        } else if (count1 < count2) {
            l1_cur = l1;
            int dif = count2 - count1;
            while (l1_cur.next != null)   // travel to the last
            {
                l1_cur = l1_cur.next;
            }

            while (dif != 0) {
                ListNode lNew = new ListNode(0);
                lNew.next = null;

                l1_cur.next = lNew;
                l1_cur = l1_cur.next;
                dif--;
            }
        } else {

        }
        //deal the equal listed
        {
            l1_cur = l1;
            l2_cur = l2;
            l3_cur = l3;
            while (l1_cur != null && l2_cur != null) {
                int c = l1_cur.val + l2_cur.val;
                ListNode lNew = new ListNode(c);
                lNew.next = null;

                l3_cur.next = lNew;
                l3_cur = l3_cur.next;

                l1_cur = l1_cur.next;
                l2_cur = l2_cur.next;
            }

            l3_cur = l3.next;  // >10 deal
            while (l3_cur != null) {
                if (l3_cur.val >= 10) {
                    l3_cur.val -= 10;
                    if (l3_cur.next != null) {

                        l3_cur.next.val += 1;
                    } else {
                        ListNode lNew = new ListNode(1);
                        lNew.next = null;

                        l3_cur.next = lNew;
                        l3_cur = lNew;
                    }

                    l3_cur = l3_cur.next;
                } else {
                    l3_cur = l3_cur.next;
                }
            }
            return l3.next;

        }

    }

}
