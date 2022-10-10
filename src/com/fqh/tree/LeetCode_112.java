package com.fqh.tree;

/**
 * @author The End of Death
 * @version 1.0
 * @since 2022/9/19 22:54:21
 */

import com.fqh.util.TreeNode;

/**
 * 112. 路径总和
 * 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum 。判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。如果存在，返回 true ；否则，返回 false 。
 * <p>
 * 叶子节点 是指没有子节点的节点。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
 * 输出：true
 * 解释：等于目标和的根节点到叶节点路径如上图所示。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_112 {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(5);
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(8);
        TreeNode node3 = new TreeNode(11);
        TreeNode node4 = new TreeNode(13);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(7);
        TreeNode node7 = new TreeNode(2);
        TreeNode node8 = new TreeNode(1);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node5.right = node8;
        int targetSum = 22;
        System.out.println(new LeetCode_112().hasPathSum(root, targetSum));
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum);
        return hasPath;
    }

    boolean hasPath = false;

    //DFS
    public void dfs(TreeNode root, int targetSum) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            if (targetSum - root.val == 0) {
                hasPath = true;
            }
            return;
        }
        if (root.left != null) {
            dfs(root.left, targetSum - root.val);
        }
        if (root.right != null) {
            dfs(root.right, targetSum - root.val);
        }
    }
}
