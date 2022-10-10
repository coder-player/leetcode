package com.fqh.codetop;

import com.fqh.util.ListNode;

/**
 * @author 海盗狗
 * @version 1.0
 * 19. 删除链表的倒数第 N 个结点
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 */
public class Solution_19 {

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
        int n = 2;
        System.out.println(removeNthFromEndIterate(head, n));

    }

    //    迭代(双指针)
    public static ListNode removeNthFromEndIterate(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;
//        将fast放在n-1的位置
        for (int i = 0; i < n - 1; i++) {
            fast = fast.next;
        }
        while (true) {
//            边界1：只有一个节点，直接返回head.next
            if (fast.next == null) {
                return head.next;
            }
//            边界2：当前fast的位置就是可以删除的位置
            if (fast.next.next == null) {
                break;
            }
            slow = slow.next;
            fast = fast.next;
        }
//        通过slow删除节点
        slow.next = slow.next.next;
        return head;
    }
}
