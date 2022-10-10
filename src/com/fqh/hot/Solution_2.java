package com.fqh.hot;

import com.fqh.util.ListNode;

/**
 * @author 海盗狗
 * @version 1.0
 * 2.两数相加
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 */
public class Solution_2 {

    public static void main(String[] args) {

        ListNode l1 = new ListNode(2);
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(3);
        l1.next = node1;
        node1.next = node2;

        ListNode l2 = new ListNode(5);
        ListNode node21 = new ListNode(6);
        ListNode node22 = new ListNode(4);
        l2.next = node21;
        node21.next = node22;

        System.out.println(addTwoNumbers(l1, l2));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        定义辅助指针
        ListNode p = l1;
        ListNode q = l2;
//        辅助头节点
        ListNode dummy = new ListNode(-1);
//        拼接节点的辅助节点
        ListNode cur = dummy;
        int val = 0;
        int incr = 0;
        while (p != null || q != null || incr < 0) {
//            将进位的值赋值给下一个val
            val = incr;
            if (p != null) {
                val += p.val;
                p = p.next;
            }
            if (q != null) {
                val += q.val;
                q = q.next;
            }
//            处理进位
            incr = val / 10;
            val = val % 10;
            ListNode node = new ListNode(val);
            cur.next = node;
            cur = cur.next;
        }
        return dummy.next;
    }
}
