package com.fqh.tree;

/**
 * @author The End of Death
 * @version 1.0
 * @since 2022/9/23 20:06:26
 */

import com.fqh.util.TreeNode;

/**
 * 700. 二叉搜索树中的搜索
 * 给定二叉搜索树（BST）的根节点 root 和一个整数值 val。
 * <p>
 * 你需要在 BST 中找到节点值等于 val 的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 null 。
 * 输入：root = [4,2,7,1,3], val = 2
 * 输出：[2,1,3]
 */
public class LeetCode_700 {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(4);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(7);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(3);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;

        TreeNode node = new LeetCode_700().searchBST(root, 2);
        System.out.println(node);
    }

    //DFS
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (val < root.val) {
            return searchBST(root.left, val);
        } else if (val > root.val) {
            return searchBST(root.right, val);
        } else {
            return root;
        }
    }
}
