package com.fqh.tree;

/**
 * @author The End of Death
 * @version 1.0
 * @since 2022/9/21 23:24:19
 */

import com.fqh.util.TreeNode;

/**
 * 101. 对称二叉树
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 * 输入：root = [1,2,2,3,4,4,3]
 * 输出：tru
 */
public class LeetCode_101 {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(3);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;

        System.out.println(new LeetCode_101().isSymmetric(root));
    }

    public boolean isSymmetric(TreeNode root) {
        return dfs(root.left, root.right);
    }

    //DFS
    public boolean dfs(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }
        if (node1.val != node2.val) {
            return false;
        }
        return dfs(node1.left, node2.right) && dfs(node1.right, node2.left);
    }
}
