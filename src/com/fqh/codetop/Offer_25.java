package com.fqh.codetop;

import com.fqh.util.ListNode;

/**
 * @author 我劝你荔枝_FQH
 * @version 1.0
 * Date: 2022/6/18 23:43:04
 */
public class Offer_25 {

    public static void main(String[] args) {

        ListNode l1 = new ListNode(1);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        l1.next = node1;
        node1.next = node2;

        ListNode l2 = new ListNode(1);
        ListNode node11 = new ListNode(1);
        ListNode node22 = new ListNode(1);
        l2.next = node11;
        node11.next = node22;
    }

    //递归
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode head = null;
        //谁小谁当head
        if (l1.val <= l2.val) {
            head = l1;
            //递归判断l1的next
            head.next = mergeTwoLists(l1.next, l2);
        } else {
            head = l2;
            //递归判断l2的next
            head.next = mergeTwoLists(l1, l2.next);
        }
        return head;
    }

    //迭代
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        //定义遍历指针
        ListNode head = new ListNode(0);
        ListNode p = l1;
        ListNode q = l2;
        ListNode cur = head;
        while (p != null && q != null) {
            //谁小head的next就指向谁
            if (p.val <= q.val) {
                cur.next = p;
                p = p.next;
            } else {
                cur.next = q;
                q = q.next;
            }
            cur = cur.next;
        }
        //还存在残留的节点直接连接到cur
        if (p != null) {
            cur.next = p;
        }
        if (q != null) {
            cur.next = q;
        }
        return head.next;
    }
}
