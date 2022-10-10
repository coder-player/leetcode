package com.fqh.hot;

import com.fqh.util.ListNode;

/**
 * @author 海盗狗
 * @version 1.0
 * 19. 删除链表的倒数第 N 个结点
 * <p>
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
        ListNode node5 = new ListNode(6);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        int n = 2;
        ListNode newHead = removeNthFromEnd(head, n);

        System.out.println(newHead);

    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;
//        fast先走n步
        for (int i = 0; i < n - 1; i++) {
            fast = fast.next;
        }
        while (true) {
//            (边界情况)要删除的是第一个节点
            if (fast.next == null) {
                return head.next;
            }
//            位置找到
            if (fast.next.next == null) {
                break;
            }
//            快慢一起走
            slow = slow.next;
            fast = fast.next;

        }
        slow.next = slow.next.next;
        return head;
    }
}
