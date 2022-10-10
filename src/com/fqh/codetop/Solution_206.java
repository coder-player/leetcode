package com.fqh.codetop;

import com.fqh.util.ListNode;

/**
 * @author 海盗狗
 * @version 1.0
 * 206.反转链表 (递归 | 迭代)
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
//        System.out.println(reverseListIterate(head));
        System.out.println(reverseListRecursion(head));
    }

    //    迭代法
    public static ListNode reverseListIterate(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode next = null;
        ListNode cur = head;
        ListNode dummy = new ListNode(-1);
        while (cur != null) {
            next = cur.next;
            cur.next = dummy.next;
            dummy.next = cur;
            cur = next;
        }
        head = dummy.next;
        return head;
    }

    //    递归法
    public static ListNode reverseListRecursion(ListNode head) {
        if (head == null || head.next == null) { //边界条件
            return head;
        }
//        让last指向最后一个节点
        ListNode last = reverseListRecursion(head.next);
//        让当前节点的下一个节点的next指向当前节点
//        4--->5--->null 5--->4--->5
        head.next.next = head;
//        把当前节点和下一个节点断开 4--->null
        head.next = null;
        return last; //返回反转好的last
    }

}
