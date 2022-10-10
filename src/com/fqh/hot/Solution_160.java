package com.fqh.hot;

import com.fqh.util.ListNode;

/**
 * @author 海盗狗
 * @version 1.0
 * 160. 相交链表
 * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
 * 输出：Intersected at '8'
 * 解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。
 * 从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,6,1,8,4,5]。
 * 在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 */
public class Solution_160 {

    public static void main(String[] args) {

        ListNode headA = new ListNode(4);
        ListNode nodeA1 = new ListNode(1);
        headA.next = nodeA1;

        ListNode headB = new ListNode(5);
        ListNode nodeB1 = new ListNode(6);
        ListNode nodeB2 = new ListNode(1);
        headB.next = nodeB1;
        nodeB1.next = nodeB2;

        ListNode nodeAB1 = new ListNode(8);
        ListNode nodeAB2 = new ListNode(4);
        ListNode nodeAB3 = new ListNode(5);
        nodeAB1.next = nodeAB2;
        nodeAB2.next = nodeAB3;

        nodeA1.next = nodeAB1;
        nodeB2.next = nodeAB1;

        System.out.println(getIntersectionNode(headA, headB).val);
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode p1 = headA;
        ListNode p2 = headB;

        while (p1 != p2) {
//            p1 走完走 headB
            if (p1 != null) {
                p1 = p1.next;
            } else {
                p1 = headB;
            }
//            p2 走完走 headA
            if (p2 != null) {
                p2 = p2.next;
            } else {
                p2 = headA;
            }
        }
        return p1;
    }
}
