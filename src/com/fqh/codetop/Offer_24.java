package com.fqh.codetop;

import com.fqh.util.ListNode;

/**
 * @author 我劝你荔枝_FQH
 * @version 1.0
 * Date: 2022/6/8 22:25:23
 * 剑指 Offer 24. 反转链表
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 */
public class Offer_24 {

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

        ListNode reverseNode = reverseList(head);
        System.out.println(reverseNode);
    }

    public static ListNode reverseList(ListNode head) {
        return recursion(head);
    }

    //迭代
    public static ListNode iterate(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = null; //next标志
        ListNode newHead = new ListNode(-1); //虚拟头节点
        ListNode cur = head; //指针节点
        while (cur != null) {
            next = cur.next;
            cur.next = newHead.next;
            newHead.next = cur;
            cur = next;
        }
        return newHead.next;
    }

    //递归
    public static ListNode recursion(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        ListNode last = recursion(head.next); //
        head.next.next = head; //5--->4--->5--->
        head.next = null;  //5--->4--->null
        return last; //5
    }
}
