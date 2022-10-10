package com.fqh.hot;

import com.fqh.util.TreeNode;

/**
 * @author 海盗狗
 * @version 1.0
 * 104. 二叉树的最大深度
 */
public class Solution_104 {

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

        System.out.println(maxDepth(root));
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
//        左右子树深度求最大值
        return Math.max(root.left == null ? 0 : maxDepth(root.left),
                (root.right == null ? 0 : maxDepth(root.right)) + 1);
    }
}
