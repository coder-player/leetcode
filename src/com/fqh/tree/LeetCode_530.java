package com.fqh.tree;

import com.fqh.util.TreeNode;

/**
 * @author The End of Death
 * @version 1.0
 * @since 2022/9/28 23:04:48
 */

/**
 * 530. 二叉搜索树的最小绝对差
 * 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
 * <p>
 * 差值是一个正数，其数值等于两值之差的绝对值。
 * 输入：root = [4,2,6,1,3]
 * 输出：1
 */
public class LeetCode_530 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(6);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(3);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;

        System.out.println(new LeetCode_530().getMinimumDifference(root));
    }

    TreeNode pre = null;
    int ans = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        dfs(root);
        return ans;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (pre != null) {
            ans = Math.min(ans, root.val - pre.val);
        }
        pre = root;
        dfs(root.right);
    }
}
