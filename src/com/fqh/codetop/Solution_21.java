package com.fqh.codetop;

import com.fqh.util.ListNode;

/**
 * @author 海盗狗
 * @version 1.0
 * 21. 合并两个有序链表 (递归|迭代)
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

//        System.out.println(mergeTwoListsRecursion(list1,list2));
        System.out.println(mergeTwoListsIterate(list1, list2));
    }


    //    递归法
    public static ListNode mergeTwoListsRecursion(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode head = null;
        if (list1.val < list2.val) {
            head = list1;
            head.next = mergeTwoListsRecursion(list1.next, list2);
        } else {
            head = list2;
            list2.next = mergeTwoListsRecursion(list1, list2.next);
        }
        return head;
    }

    //    迭代法
    public static ListNode mergeTwoListsIterate(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode l1 = list1;
        ListNode l2 = list2;
        ListNode p = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) { //比较两个节点谁值小就连接到p的后面
                p.next = l1;
                l1 = l1.next; //指针移动
            } else {
                p.next = l2;
                l2 = l2.next; //指针移动
            }
            p = p.next; //指针移动
        }
        if (l1 != null) { //如果l1还不为null, 就直接接到p后面
            p.next = l1;
        }
        if (l2 != null) {
            p.next = l2;
        }
        return dummy.next;
    }

}
