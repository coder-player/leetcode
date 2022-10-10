package com.fqh.hot;

import com.fqh.util.ListNode;

/**
 * @author 海盗狗
 * @version 1.0
 * 21. 合并两个有序链表
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 */
public class Solution_21 {

    public static void main(String[] args) {

        ListNode list1 = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(4);
        list1.next = node1;
        node1.next = node2;

        ListNode list2 = new ListNode(1);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        list2.next = node3;
        node3.next = node4;

        ListNode newHead = mergeTwoLists(list1, list2);
        System.out.println(newHead);
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode head = null;
//        谁小谁当head
        if (list1.val < list2.val) {
//            把list1当作头
            head = list1;
//            递归把list1的next元素跟list2做比较
            head.next = mergeTwoLists(list1.next, list2);
        } else {
//            把list2当作头
            head = list2;
//            递归把list2.next的元素与list1做比较
            head.next = mergeTwoLists(list1, list2.next);
        }
        return head;
    }
}
