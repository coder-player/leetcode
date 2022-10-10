package com.fqh.codetop;

import com.fqh.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 我劝你荔枝_FQH
 * @version 1.0
 * Date: 2022/6/2 22:46:12
 * 230. 二叉搜索树中第K小的元素
 * <p>
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
 * <p>
 * 输入：root = [3,1,4,null,2], k = 1
 * 输出：1
 */
public class Solution_230 {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(2);

        root.left = node1;
        root.right = node2;
        node1.right = node3;

        int k = 1;
        System.out.println(kthSmallest(root, k));
    }

    public static int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        System.out.println(list);
        return list.get(k - 1);

    }

    /**
     * **************
     * dfs传入list存放遍历二叉搜索树结果
     * *******************
     */
    public static void dfs(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        dfs(root.left, list);
        list.add(root.val);
        dfs(root.right, list);
    }

}
