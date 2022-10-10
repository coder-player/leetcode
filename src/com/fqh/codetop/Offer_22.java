package com.fqh.codetop;

import com.fqh.util.ListNode;

/**
 * @author 海盗狗
 * @version 1.0
 * 剑指 Offer 22. 链表中倒数第k个节点
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 * <p>
 * 返回链表 4->5.
 */
public class Offer_22 {

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
        int k = 2;

        System.out.println(getKthFromEnd(head, k));
    }

    //    双指针大法
    public static ListNode getKthFromEnd(ListNode head, int k) {

//        定义快慢指针
        ListNode slow = head;
        ListNode fast = head;

//        先让fast移动到k-1位置
        for (int i = 0; i < k - 1; i++) {
            fast = fast.next;
        }
//        fast走到最后一个位置时, slow所在的位置就是倒数第k个位置
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
