package com.fqh.codetop;

import com.fqh.util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 我劝你荔枝_FQH
 * @version 1.0
 * Date: 2022/5/30 10:39:00
 * 111. 二叉树的最小深度
 * 给定一个二叉树，找出其最小深度。
 * <p>
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * <p>
 * 说明：叶子节点是指没有子节点的节点。
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：2
 */
public class Solution_111 {

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

        System.out.println(minDepth(root));
    }

    //bfs
    public static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int minDepth = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                if (node == null) {
                    break;
                }
                //层序遍历遇到第一个子节点为null的就返回
                if (node.left == null && node.right == null) {
                    return minDepth;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            minDepth++; //下一层
        }
        return minDepth;
    }

    //dfs

}
