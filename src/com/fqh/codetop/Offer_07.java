package com.fqh.codetop;

import com.fqh.util.TreeNode;

/**
 * @author 我劝你荔枝_FQH
 * @version 1.0
 * Date: 2022/6/16 23:33:34
 * 剑指 Offer 07. 重建二叉树
 * 输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。
 * <p>
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * <p>
 * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * Output: [3,9,20,null,null,15,7]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/zhong-jian-er-cha-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Offer_07 {

    public static void main(String[] args) {

        int[] preorder = {3, 9, 20, 15, 7}, inorder = {9, 3, 15, 20, 7};
        TreeNode tree = buildTree(preorder, inorder);

        System.out.println(tree);
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return dfs(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    //dfs构建
    public static TreeNode dfs(int[] preorder, int pStart, int pEnd, int[] inorder, int inStart, int inEnd) {
        if (inStart > inEnd) {
            return null;
        }
        //前序遍历首个是root的值
        int rootVal = preorder[pStart];
        int index = 0;
        //找出中序遍历中root的索引
        for (int i = inStart; i < inorder.length; i++) {
            if (inorder[i] == rootVal) {
                index = i;
                break;
            }
        }
        TreeNode root = new TreeNode(rootVal);
        //计算左子树元素个数
        int leftSize = index - inStart;
        //递归构建左右子树
        root.left = dfs(preorder, pStart + 1, pStart + leftSize, inorder, inStart, index - 1);
        root.right = dfs(preorder, pStart + leftSize + 1, pEnd, inorder, index + 1, inEnd);
        return root;
    }
}
