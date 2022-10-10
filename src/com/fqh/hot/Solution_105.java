package com.fqh.hot;

import com.fqh.util.TreeNode;

/**
 * @author 海盗狗
 * @version 1.0
 * 105. 从前序与中序遍历序列构造二叉树
 */
public class Solution_105 {

    public static void main(String[] args) {

        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};

        TreeNode root = buildTree(preorder, inorder);
        System.out.println(root.val);
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {

        TreeNode root = dfs(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
        return root;
    }

    public static TreeNode dfs(int[] preorder, int pStart, int pEnd, int[] inorder, int inStart, int inEnd) {
        if (pStart > pEnd) {
            return null;
        }
//        root节点对应的值就是前序遍历数组的第一个元素
        int rootVal = preorder[pStart];
//        rootVal 在中序遍历数组中的索引
        int index = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootVal) {
                index = i;
                break;
            }
        }
        int leftSize = index - inStart;
        TreeNode root = new TreeNode(rootVal);

        root.left = dfs(preorder, pStart + 1, pStart + leftSize, inorder, inStart, index - 1);
        root.right = dfs(preorder, pStart + leftSize + 1, pEnd, inorder, index + 1, inEnd);
        return root;
    }
}
