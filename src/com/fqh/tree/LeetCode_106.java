package com.fqh.tree;

/**
 * @author The End of Death
 * @version 1.0
 * @since 2022/9/19 23:20:38
 */

import com.fqh.util.TreeNode;

/**
 * 106. 从中序与后序遍历序列构造二叉树
 * 给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并返回这颗 二叉树 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/construct-binary-tree-from-inorder-and-postorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并返回这颗 二叉树 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/construct-binary-tree-from-inorder-and-postorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_106 {

    public static void main(String[] args) {

        // [9|3|15|20|7] index = 1 leftSize = 1;
        // [9|15|7|20|3]
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};
        TreeNode root = new LeetCode_106().buildTree(inorder, postorder);
        System.out.println(root);
        System.out.println("");
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return dfs(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    //DFS
    public TreeNode dfs(int[] inorder, int inStart, int inEnd,
                        int[] postorder, int pStart, int pEnd) {
        if (pStart > pEnd) {
            return null;
        }
        int index = 0;
        int rootVal = postorder[pEnd];
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootVal) {
                index = i;
                break;
            }
        }
        int leftSize = index - inStart;
        TreeNode root = new TreeNode(rootVal);
        root.left = dfs(inorder, inStart, index - 1, postorder, pStart, pStart + leftSize - 1);
        root.right = dfs(inorder, index + 1, inEnd, postorder, pStart + leftSize, pEnd - 1);
        return root;
    }
}
