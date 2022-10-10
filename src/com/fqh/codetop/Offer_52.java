package com.fqh.codetop;

import com.fqh.util.ListNode;

/**
 * @author 我劝你荔枝_FQH
 * @version 1.0
 * Date: 2022/6/4 22:24:15
 * 剑指 Offer 52. 两个链表的第一个公共节点
 * 输入两个链表，找出它们的第一个公共节点。
 * <p>
 * 如下面的两个链表：
 * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * 输出：Reference of the node with value = 8
 * 输入解释：相交节点的值为 8 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Offer_52 {

    public static void main(String[] args) {

        ListNode headA = new ListNode(4);
        ListNode node1 = new ListNode(1);

        ListNode headB = new ListNode(5);
        ListNode node11 = new ListNode(0);
        ListNode node111 = new ListNode(1);

        ListNode node22 = new ListNode(8);
        ListNode node33 = new ListNode(4);
        ListNode node44 = new ListNode(5);

        node22.next = node33;
        node33.next = node44;

        headA.next = node1;
        node1.next = node22;

        headB.next = node11;
        node11.next = node111;
        node111.next = node22;

        System.out.println(getIntersectionNode(headA, headB));
    }

    //双指针
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode p = headA;
        ListNode q = headB;
        while (p != q) {
            //如果p走到headA的尽头就开走headB
            if (p == null) {
                p = headB;
            } else {
                p = p.next;
            }
            //如果q走到headB的尽头就开走headA
            if (q == null) {
                q = headA;
            } else {
                q = q.next;
            }
        }
        //循环结束, p,q相遇
        return p;
    }
}
