package com.fqh.tree;

/**
 * @author The End of Death
 * @version 1.0
 * @since 2022/9/13 23:14:21
 */

import com.fqh.util.TreeNode;

/**
 * 513. 找树左下角的值
 * 给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
 * <p>
 * 假设二叉树中至少有一个节点。
 * 输入: [1,2,3,4,null,5,6,null,null,7]
 * 输出: 7
 */
public class LeetCode_513 {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(6);
        TreeNode node6 = new TreeNode(7);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node2.left = node4;
        node2.right = node5;
        node4.left = node6;

        int bottomLeftValue = new LeetCode_513().findBottomLeftValue(root);
        System.out.println(bottomLeftValue);
    }

    int maxDepth = Integer.MIN_VALUE;
    int result = 0;

    public int findBottomLeftValue(TreeNode root) {
        dfs(root, 1);
        return result;
    }

    //DFS
    public void dfs(TreeNode root, int depth) {
        if (root.left == null && root.right == null) {
            if (depth > maxDepth) {
                maxDepth = depth;
                result = root.val;
            }
            return;
        }
        if (root.left != null) {
            dfs(root.left, depth + 1);
        }
        if (root.right != null) {
            dfs(root.right, depth + 1);
        }
    }
}
