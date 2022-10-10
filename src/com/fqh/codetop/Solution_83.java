package com.fqh.codetop;

import com.fqh.util.ListNode;

/**
 * @author 海盗狗
 * @version 1.0
 * 83. 删除排序链表中的重复元素
 * 给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。
 * 输入：head = [1,1,2,3,3]
 * 输出：[1,2,3]
 */
public class Solution_83 {

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        head.next = node1;
        node1.next = node2;

        System.out.println(deleteDuplicates(head));
    }

    //    迭代
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode temp = head; //指向head的指针
        ListNode dummy = new ListNode(-1); //虚拟头节点
        ListNode cur = dummy; //指向dummy的指针
        while (temp != null) {
//            如果当前节点的下一个节点不为空并且当前节点的值跟下一个节点的值相等
//            就抛弃当前节点成为下一个节点
            if (temp.next != null && temp.val == temp.next.val) {
                temp = temp.next;
            } else {
//                将temp指向的节点一个个接入cur
                cur.next = temp;
                temp = temp.next;
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}
