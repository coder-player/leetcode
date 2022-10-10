package com.fqh.hot;

import com.fqh.util.ListNode;

/**
 * @author 海盗狗
 * @version 1.0
 * 142. 环形链表 II
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：返回索引为 1 的链表节点
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 */
public class Solution_142 {

    public static void main(String[] args) {

        ListNode head = new ListNode(3);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(-4);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node1;

        System.out.println(detectCycle(head).val);
    }

    public static ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        boolean flag = false;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
//                有环更新flag的值
                flag = true;
                break;
            }
        }
        if (flag) {
//        将slow复原. 与fast再次相遇就是相遇的节点
            slow = head;
            while (slow != fast) {
                slow = slow.next;
                fast = fast.next;
            }
            return slow;
        } else {
            return null;
        }
    }
}
