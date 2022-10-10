package com.fqh.codetop;

import com.fqh.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 海盗狗
 * @version 1.0
 */
public class Solution_145 {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        root.right = node1;
        node1.left = node2;

        System.out.println(postorderTraversal(root));
    }

    public static List<Integer> postorderTraversal(TreeNode root) {
        return dfs(root);
    }

    static List<Integer> list = new ArrayList<>();

    //    dfs深搜
    public static List<Integer> dfs(TreeNode root) {
        if (root == null) {
            return list;
        }
        dfs(root.left);
        dfs(root.right);
        list.add(root.val);
        return list;
    }
}
