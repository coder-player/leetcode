package com.fqh.codetop;

import com.fqh.util.TreeNode;

import java.util.*;

/**
 * @author 海盗狗
 * @version 1.0
 * 103. 二叉树的锯齿形层序遍历
 * 给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[3],[20,9],[15,7]]
 */
public class Solution_103 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);
        root.left = node1;
        root.right = node2;
        node2.left = node3;
        node2.right = node4;

        System.out.println(zigzagLevelOrder(root));
    }

    //    bfs
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
//        判断当前的层数
        int level = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
//            使用万能的LinkedList
            LinkedList<Integer> list = new LinkedList<>();
            int n = queue.size();
            if (level % 2 == 0) {
                for (int i = 0; i < n; i++) {
                    TreeNode node = queue.poll();
                    if (node == null) {
                        break;
                    }
//                    偶数层采用头插法
                    list.addFirst(node.val);
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
            } else {
                for (int i = 0; i < n; i++) {
                    TreeNode node = queue.poll();
                    if (node == null) {
                        break;
                    }
                    list.add(node.val);
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
            }
            level++;
            res.add(list);
        }
        return res;
    }
}
