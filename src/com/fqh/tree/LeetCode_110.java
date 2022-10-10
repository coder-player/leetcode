package com.fqh.tree;

/**
 * @author 鸽鸽
 * @version 1.0
 * Date: 2022/9/11 19:58:01
 */

import com.fqh.util.TreeNode;

/**
 * 110. 平衡二叉树
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * <p>
 * 本题中，一棵高度平衡二叉树定义为：
 * <p>
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/balanced-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：true
 */
public class LeetCode_110 {

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

        System.out.println(isBalanced(root));
    }

    public static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (Math.abs(height(root.left)) - height(root.right) > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public static int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(height(root.left), height(root.right)) + 1;
    }

    /**
     * Carl解法
     *
     * @param root
     * @return
     */
    public static int heightT(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lh = heightT(root.left);
        if (lh == -1) {
            return -1;
        }
        int rh = heightT(root.right);
        if (rh == -1) {
            return -1;
        }
        int result;
        if (Math.abs(rh - lh) > 1) {
            return -1;
        }
        result = Math.max(rh, lh) + 1;
        return result;
    }
}
