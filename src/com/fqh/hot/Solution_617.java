package com.fqh.hot;

import com.fqh.util.TreeNode;

/**
 * @author 海盗狗
 * @version 1.0
 * 617. 合并二叉树
 */
public class Solution_617 {

    public static void main(String[] args) {

        TreeNode root1 = new TreeNode(1);
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(5);
        root1.left = node1;
        root1.right = node2;
        node1.left = node3;

        TreeNode root2 = new TreeNode(2);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(3);
        TreeNode node6 = new TreeNode(4);
        TreeNode node7 = new TreeNode(7);
        root2.left = node4;
        node4.right = node6;
        root2.right = node5;
        node5.right = node7;

        TreeNode mergeTrees = mergeTrees(root1, root2);
        System.out.println(mergeTrees.val);

    }

    public static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        return merge(root1, root2);
    }

    public static TreeNode merge(TreeNode p, TreeNode q) {
//        如果p q都为null, 返回null
        if (p == null && q == null) {
            return null;
        }
//        将两个节点的val相加作为新的节点的val
        TreeNode root = new TreeNode((p == null ? 0 : p.val) + (q == null ? 0 : q.val));
//        递归合并左子树
        root.left = merge((p == null ? null : p.left), (q == null ? null : q.left));
//        递归合并右子树
        root.right = merge((p == null ? null : p.right), (q == null ? null : q.right));
        return root;
    }
}
