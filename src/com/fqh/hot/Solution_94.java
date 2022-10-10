package com.fqh.hot;

import com.fqh.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 海盗狗
 * @version 1.0
 * 94. 二叉树的中序遍历
 */
public class Solution_94 {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        root.right = node1;
        node1.left = node2;

        List<Integer> traversal = inorderTraversal(root);
        System.out.println(traversal);
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        dfs(root, res);
        return res;
    }

    public static void dfs(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
//        左子树 - 根节点 - 右子树
        dfs(root.left, res);
        res.add(root.val);
        dfs(root.right, res);
    }
}
