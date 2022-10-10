package com.fqh.hot;

import com.fqh.util.TreeNode;

/**
 * @author 海盗狗
 * @version 1.0
 * 538. 把二叉搜索树转换为累加树
 */
public class Solution_538 {

    static int sum;

    public static void main(String[] args) {

        TreeNode root = new TreeNode(4);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(6);
        TreeNode node3 = new TreeNode(0);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(3);
        TreeNode node6 = new TreeNode(5);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node4.right = node5;
        node2.left = node6;
        node2.right = node7;
        node7.right = node8;

        TreeNode convertBST = convertBST(root);
        System.out.println(convertBST.val);
    }

    public static TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        dfs(root);
        return root;
    }

    public static void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
//        从最右边的元素开始累加
        if (root.right != null) {
            dfs(root.right);
        }
        sum += root.val;
//        将累加的值赋值给当前节点
        root.val = sum;
        if (root.left != null) {
            dfs(root.left);
        }
    }
}
