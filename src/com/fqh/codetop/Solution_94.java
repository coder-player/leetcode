package com.fqh.codetop;

import com.fqh.util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author 海盗狗
 * @version 1.0
 * 94. 二叉树的中序遍历
 * 输入：root = [1,null,2,3]
 * 输出：[1,3,2]
 */
public class Solution_94 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        root.right = node1;
        node1.left = node2;

        System.out.println(inorderTraversal(root));
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
//        return dfs(root, list);
        return iterate(root, list);
    }

    //    递归
    public static List<Integer> dfs(TreeNode root, List<Integer> list) {
        if (root == null) {
            return list;
        }
        dfs(root.left, list);
        list.add(root.val);
        dfs(root.right, list);
        return list;
    }

    //    迭代
    public static List<Integer> iterate(TreeNode root, List<Integer> list) {
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);   //将节点入栈
                root = root.left;   //继续向左迭代
            }
            root = stack.pop(); //从栈中弹出一个节点当作新的root
            list.add(root.val); //中序位置
            root = root.right; //把当前root的右节点当作新的root
        }
        return list;
    }
}
