package com.fqh.hot;

import com.fqh.util.ListNode;

/**
 * @author 海盗狗
 * @version 1.0
 * 141. 环形链表
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 */
public class Solution_141 {

    public static void main(String[] args) {

        ListNode head = new ListNode(3);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(-4);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
//        node3.next = node1;

        System.out.println(hasCycle(head));
    }

    public static boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
//       快慢指针
        ListNode fast = head;
        ListNode slow = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
//            有环则相遇
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}
