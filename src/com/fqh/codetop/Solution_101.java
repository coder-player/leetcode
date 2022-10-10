package com.fqh.codetop;

import com.fqh.util.TreeNode;

/**
 * @author 海盗狗
 * @version 1.0
 * 101. 对称二叉树
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 * 输入：root = [1,2,2,3,4,4,3]
 * 输出：true
 */
public class Solution_101 {

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

        System.out.println(isSymmetric(root));
    }

    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return dfs(root.left, root.right);
    }

    //    dfs
    public static boolean dfs(TreeNode p, TreeNode q) {
//        p, q都为null返回true
        if (p == null && q == null) {
            return true;
        }
//        p, q其中一个为null返回false
        if (p == null || q == null) {
            return false;
        }
//        p, q的值不相等也返回false
        if (p.val != q.val) {
            return false;
        }
//        递归p左q右---p右q左
        return dfs(p.left, q.right) && dfs(p.right, q.left);
    }
}
