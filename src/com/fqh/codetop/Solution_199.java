package com.fqh.codetop;

import com.fqh.util.TreeNode;

import java.util.*;

/**
 * @author 海盗狗
 * @version 1.0
 * 199. 二叉树的右视图
 * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1,3,4]
 */
public class Solution_199 {

    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        ;
        TreeNode node3 = new TreeNode(5);
        TreeNode node4 = new TreeNode(4);
        root.left = node1;
        root.right = node2;
        node1.right = node3;
        node2.right = node4;

        System.out.println(rightSideViewDFS(root, 0));
    }

    //    bfs
    public static List<Integer> rightSideViewBFS(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                if (node == null) {
                    break;
                }
                if (i == n - 1) {
                    list.add(node.val);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return list;
    }

    //    dfs
    public static List<Integer> rightSideViewDFS(TreeNode root, int depth) {
        if (root == null) {
            return list;
        }
        if (depth == list.size()) {
//            说明是第一个到达这一层的元素
            list.add(root.val);
        }
        depth++;
//        先递归右子树
        rightSideViewDFS(root.right, depth);
        rightSideViewDFS(root.left, depth);
        return list;
    }
}
