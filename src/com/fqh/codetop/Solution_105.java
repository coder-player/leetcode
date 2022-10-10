package com.fqh.codetop;

import com.fqh.util.TreeNode;

/**
 * @author 海盗狗
 * @version 1.0
 * 105. 从前序与中序遍历序列构造二叉树
 * 输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * 输出: [3,9,20,null,null,15,7]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_105 {

    public static void main(String[] args) {

        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        System.out.println(buildTree(preorder, inorder));
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {

        return dfs(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public static TreeNode dfs(int[] preorder, int pStart, int pEnd,
                               int[] inorder, int inStart, int inEnd) {
//        边界条件
        if (pStart > pEnd) {
            return null;
        }
//        前序遍历的第一个元素就是root
        int rootVal = preorder[pStart];
        int index = 0;
//        去中序遍历中查找中序遍历的root节点的索引
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootVal) {
                index = i;
                break;
            }
        }
        TreeNode root = new TreeNode(rootVal);
        int leftSize = index - inStart; //左子树元素的长度
//        递归构建左右子树
        root.left = dfs(preorder, pStart + 1, pStart + leftSize, inorder, inStart, index);
        root.right = dfs(preorder, pStart + leftSize + 1, pEnd, inorder, index + 1, inEnd);
        return root;
    }
}
