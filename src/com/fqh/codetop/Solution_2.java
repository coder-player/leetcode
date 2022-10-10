package com.fqh.codetop;

import com.fqh.util.ListNode;

/**
 * @author 海盗狗
 * @version 1.0
 * 2. 两数相加
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 */
public class Solution_2 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(3);
        l1.next = node1;
        node1.next = node2;

        ListNode l2 = new ListNode(5);
        ListNode node3 = new ListNode(6);
        ListNode node4 = new ListNode(4);
        l2.next = node3;
        node3.next = node4;

        ListNode twoNumbers = addTwoNumbers(l1, l2);
        System.out.println(twoNumbers);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p = l1;
        ListNode q = l2;
        ListNode dummy = new ListNode(-1); //虚拟头节点
        ListNode cur = dummy;
        int val = 0;
        int incr = 0; //增长值
        while (p != null || q != null || incr > 0) {
            val = incr;
            if (p != null) {
                val += p.val; //将l1节点的值累加到val
                p = p.next;
            }
            if (q != null) {
                val += q.val; //将l2节点的值累加到val
                q = q.next;
            }
            incr = val / 10; //处理计算结果进位的情况
            val = val % 10;  //处理计算结果 > 10的情况
            cur.next = new ListNode(val);
            cur = cur.next;
        }
        return dummy.next;
    }
}
