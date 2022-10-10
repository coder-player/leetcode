package com.fqh.tree;

/**
 * @author 鸽鸽
 * @version 1.0
 * Date: 2022/9/11 18:53:12
 */

import com.fqh.util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 404. 左叶子之和
 * 给定二叉树的根节点 root ，返回所有左叶子之和。
 * <p>
 * 输入: root = [3,9,20,null,null,15,7]
 * 输出: 24
 * 解释: 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 * 来源：力扣（LeetCode)
 * 链接：https://leetcode.cn/problems/sum-of-left-leaves
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_404 {

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

        System.out.println(sumOfLeftLeaves(root));
    }

    public static int sumOfLeftLeaves(TreeNode root) {
//    return bfs(root);
        return dfs(root);
    }

    static int l_sum = 0;

    public static int dfs(TreeNode root) {
        if (root == null) {
            return l_sum;
        }
        if (root.left != null) {
            if (root.left.left == null && root.left.right == null) {
                l_sum += root.left.val;
            }
        }
        dfs(root.left);
        dfs(root.right);
        return l_sum;
    }

    public static int bfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int sum = 0;
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                if (node == null) break;
                if (i == 0 && (node.left == null && node.right == null)) {
                    sum += node.val;
                }
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }
        return sum;
    }
}
