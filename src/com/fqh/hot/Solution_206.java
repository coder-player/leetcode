package com.fqh.hot;

import com.fqh.util.ListNode;

/**
 * @author 海盗狗
 * @version 1.0
 * 206. 反转链表
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 */
public class Solution_206 {

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ListNode reverseList = reverseList(head);

        System.out.println(reverseList);
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = null;
        ListNode cur = head;
        ListNode newHead = new ListNode(-1);

        while (cur != null) {
            next = cur.next;
            cur.next = newHead.next;
            newHead.next = cur;
            cur = next;
        }

        return newHead.next;
    }
}
