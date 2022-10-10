package com.fqh.codetop;

import com.fqh.util.TreeNode;

/**
 * @author 海盗狗
 * @version 1.0
 * 剑指 Offer 27. 二叉树的镜像
 * 4
 * /  \
 * 2     7
 * / \      / \
 * 1  3     6    9
 * 镜像输出：
 * <p>
 * 4
 * /       \
 * 7         2
 * / \     / \
 * 9      6   3    1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Offer_27 {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(4);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(7);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(6);
        TreeNode node6 = new TreeNode(9);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;

        TreeNode tree = mirrorTree(root);
        System.out.println(tree);
    }

    public static TreeNode mirrorTree(TreeNode root) {
        return dfs(root);
    }

    /**
     * ***************
     * dfs递归构造
     * ******************
     */
    public static TreeNode dfs(TreeNode root) {
        if (root == null) {
            return null;
        }
        //临时节点当前交换用
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        //递归左右子树
        dfs(root.left);
        dfs(root.right);
        return root;
    }
}
