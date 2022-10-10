package com.fqh.codetop;

import com.fqh.util.ListNode;

/**
 * @author 海盗狗
 * @version 1.0
 * 160.相交链表
 * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
 * 输出：Intersected at '8'
 * 解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。
 * 从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,6,1,8,4,5]。
 * 在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-linked-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_160 {

    public static void main(String[] args) {

        ListNode headA = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        headA.next = node1;
        node1.next = node2;

        ListNode headB = new ListNode(11);
        ListNode node11 = new ListNode(22);
        headB.next = node11;
        node11.next = node2;

        ListNode c1 = new ListNode(7);
        ListNode c2 = new ListNode(8);
        ListNode c3 = new ListNode(9);
        node2.next = c1;
        c1.next = c2;
        c2.next = c3;

        System.out.println(getIntersectionNode(headA, headB));
    }

    //    双指针
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA;
        ListNode p2 = headB;

        while (p1 != p2) {
            if (p1 != null) {
                p1 = p1.next; //先走自己的路
            } else {
                p1 = headB; //开始走p2的路
            }
            if (p2 != null) {
                p2 = p2.next;
            } else {
                p2 = headA; //开始走p1的路
            }
        }
        return p1;
    }
}
