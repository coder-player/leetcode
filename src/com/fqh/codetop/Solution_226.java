package com.fqh.codetop;

import com.fqh.util.TreeNode;

/**
 * @author 海盗狗
 * @version 1.0
 * 226. 翻转二叉树
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 */
public class Solution_226 {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(4);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(7);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(6);
        TreeNode node6 = new TreeNode(9);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;

        TreeNode reverseRoot = invertTree(root);
        System.out.println(reverseRoot);
    }

    public static TreeNode invertTree(TreeNode root) {
        return dfs(root);
    }

    public static TreeNode dfs(TreeNode root) {
        if (root == null) {
            return null;
        }
//        辅助节点用于交换 【把翻转看做是一个子问题】
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        dfs(root.left); //递归翻转左子树
        dfs(root.right); //递归翻转右子树
        return root;
    }
}
