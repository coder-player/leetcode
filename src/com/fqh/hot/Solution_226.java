package com.fqh.hot;

import com.fqh.util.TreeNode;

/**
 * @author 海盗狗
 * @version 1.0
 * 226. 翻转二叉树
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

        invertTree(root);

        System.out.println(root.left.val + ":" + root.right.val);

    }

    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
//        辅助变量
        TreeNode cur = null;
//        交换左右节点
        cur = root.left;
        root.left = root.right;
        root.right = cur;
//        递归交换
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
