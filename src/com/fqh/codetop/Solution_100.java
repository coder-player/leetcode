package com.fqh.codetop;

import com.fqh.util.TreeNode;

/**
 * @author 我劝你荔枝_FQH
 * @version 1.0
 * Date: 2022/6/5 23:03:11
 * 100. 相同的树
 * 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
 * <p>
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 * 输入：p = [1,2,3], q = [1,2,3]
 * 输出：true
 */
public class Solution_100 {

    public static void main(String[] args) {

        TreeNode p = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        p.left = node1;
        p.right = node2;

        TreeNode q = new TreeNode(1);
        TreeNode node11 = new TreeNode(2);
        TreeNode node22 = new TreeNode(3);
        q.left = node11;
        q.right = node22;

        System.out.println(isSameTree(p, q));
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        return dfs(p, q);
    }

    //dfs判断
    public static boolean dfs(TreeNode p, TreeNode q) {
        if (p == null && q == null) { //p, q都遍历到null 返回true
            return true;
        }
        if (p == null || q == null) { //p, q其中一个为null 返回false
            return false;
        }
        if (p.val != q.val) { //p, q的值不相同 返回false
            return false;
        }
        //递归判断p, q左右子树
        return dfs(p.left, q.left) && dfs(p.right, q.right);
    }
}
