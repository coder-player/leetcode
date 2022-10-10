package com.fqh.tree;

/**
 * @author 鸽鸽
 * @version 1.0
 * Date: 2022/9/11 17:14:52
 */

import com.fqh.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 257. 二叉树的所有路径
 * 给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
 * <p>
 * 叶子节点 是指没有子节点的节点。
 * 输入：root = [1,2,3,null,5]
 * 输出：["1->2->5","1->3"]
 */
public class LeetCode_257 {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(5);
        root.left = node1;
        root.right = node2;
        node1.right = node3;
        List<String> treePaths = binaryTreePaths(root);
        System.out.println(treePaths);

    }

    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> treePaths = new ArrayList<>();
        dfs(root, treePaths, "");
        return treePaths;
    }

    public static void dfs(TreeNode root, List<String> treePaths, String sb) {
        if (root == null) {
            return;
        }
        sb += root.val;
        if (root.left == null && root.right == null) {
            treePaths.add(sb);
            return;
        }
        dfs(root.left, treePaths, sb + "->");
        dfs(root.right, treePaths, sb + "->");


    }
}
