package com.fqh.codetop;

import com.fqh.util.TreeNode;

/**
 * @author 我劝你荔枝_FQH
 * @version 1.0
 * Date: 2022/6/18 23:15:38
 * 404. 左叶子之和
 * 输入: root = [3,9,20,null,null,15,7]
 * 输出: 24
 * 解释: 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/sum-of-left-leaves
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_404 {

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

    static int l_sum = 0;

    //dfs
    public static int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return l_sum;
        }
        //如果当前节点的左子节点不为null, 并且确保left是左子节点【左右子树为null】
        if (root.left != null && (root.left.left == null && root.left.right == null)) {
            //进行左叶子累加和
            l_sum += root.left.val;
        }
        //递归累加
        sumOfLeftLeaves(root.left);
        sumOfLeftLeaves(root.right);
        return l_sum;
    }

}
