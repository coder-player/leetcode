package com.fqh.codetop;

import com.fqh.util.ListNode;

/**
 * @author 我劝你荔枝_FQH
 * @version 1.0
 * Date: 2022/6/15 23:31:47
 * 234. 回文链表
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 * 输入：head = [1,2,2,1]
 * 输出：true
 */
public class Solution_234 {

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(1);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;

        System.out.println(isPalindrome(head));

    }

    //双指针 + 反转后半部分比较
    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode fast = head;
        ListNode slow = head;
        //快慢指针找中点
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        //将反转的slow重新赋值
        slow = reverse(slow);
        //迭代判断
        while (slow != null) {
            if (head.val != slow.val) {
                return false;
            }
            slow = slow.next;
            head = head.next;
        }
        return true;
    }

    //递归反转后半部分
    public static ListNode reverse(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }
}
