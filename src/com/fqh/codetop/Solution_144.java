package com.fqh.codetop;

import com.fqh.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 海盗狗
 * @version 1.0
 * 144. 二叉树的前序遍历
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 * 输入：root = [1,null,2,3]
 * 输出：[1,2,3]
 */
public class Solution_144 {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        root.right = node1;
        node1.left = node2;

        System.out.println(preorderTraversal(root));
    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        return dfs(root, res);
    }

    //    递归
    public static List<Integer> dfs(TreeNode root, List<Integer> res) {
        if (root == null) {
            return res;
        }
        res.add(root.val);
        dfs(root.left, res);
        dfs(root.right, res);
        return res;
    }
}
