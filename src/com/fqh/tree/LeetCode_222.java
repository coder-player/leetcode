package com.fqh.tree;

import com.fqh.util.TreeNode;

/**
 * @author 鸽鸽
 * @version 1.0
 * Date: 2022/9/11 21:27:37
 * 题目描述
 * 评论 (838)
 * 题解 (1.4k)
 * 提交记录
 * 222. 完全二叉树的节点个数
 * 给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。
 * <p>
 * 完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/count-complete-tree-nodes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 输入：root = [1,2,3,4,5,6]
 * 输出：6
 */
public class LeetCode_222 {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(6);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        int nodes = new LeetCode_222().countNodes(root);
        System.out.println(nodes);
    }

    // DFS
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = 0;
        int r = 0;
        TreeNode left = root;
        TreeNode right = root;
        while (left != null) {
            l++;
            left = left.left;
        }
        while (right != null) {
            r++;
            right = right.right;
        }
        if (l == r) {
            return (int) (Math.pow(2, l) - 1);
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}
