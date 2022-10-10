package com.fqh.hot;

import com.fqh.util.ListNode;

import java.util.PriorityQueue;

/**
 * @author 我劝你荔枝_FQH
 * @version 1.0
 * Date: 2022/6/10 10:58:40
 * 23. 合并K个升序链表
 * 给你一个链表数组，每个链表都已经按升序排列。
 * <p>
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * 示例 1：
 * <p>
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/merge-k-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_23 {

    public static void main(String[] args) {

        ListNode[] lists = new ListNode[3];
        ListNode head1 = new ListNode(1);
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(5);
        head1.next = node1;
        node1.next = node2;

        ListNode head2 = new ListNode(1);
        ListNode node11 = new ListNode(4);
        ListNode node22 = new ListNode(5);
        head2.next = node11;
        node11.next = node22;

        ListNode head3 = new ListNode(2);
        ListNode node111 = new ListNode(6);
        head3.next = node111;

        lists[0] = head1;
        lists[1] = head2;
        lists[2] = head3;

        System.out.println(mergeKLists(lists));

    }

    //优先队列
    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        //优先队列指定val小的节点排在前面
        PriorityQueue<ListNode> pq = new PriorityQueue<>(
                (o1, o2) -> o1.val - o2.val
        );
        //遍历每组的第一个节点[head]加入队列
        for (ListNode node : lists) {
            if (node == null) {
                continue;
            }
            pq.offer(node);
        }
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy; //移动指针
        while (!pq.isEmpty()) {
            ListNode node = pq.poll(); //弹出一个节点
            cur.next = node; //将cur和node连接起来
            if (node.next != null) { //如果当前节点有next节点
                pq.offer(node.next); //将next节点也加入优先队列
            }
            cur = cur.next; //移动指针

        }
        return dummy.next;
    }

}
