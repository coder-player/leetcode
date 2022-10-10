package com.fqh.codetop;

import com.fqh.util.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 我劝你荔枝_FQH
 * @version 1.0
 * Date: 2022/5/1 13:29:08
 * 106. 从中序与后序遍历序列构造二叉树
 * 给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并返回这颗 二叉树
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 输入：inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
 * 输出：[3,9,20,null,null,15,7]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_106 {

    public static void main(String[] args) {

        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};
        TreeNode root = buildTree(inorder, postorder);
        System.out.println(root);
    }

    static Map<Integer, Integer> inorderMap = new HashMap<>(); //存储中序遍历的值索引映射

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return dfs(inorder, 0, inorder.length - 1,
                postorder, 0, postorder.length - 1);
    }

    public static TreeNode dfs(int[] inorder, int inStart, int inEnd,
                               int[] postorder, int pStart, int pEnd) {
        if (inStart > inEnd) {
            return null;
        }
        int rootVal = postorder[pEnd]; //后序遍历的最后一个元素是root节点
        int index = inorderMap.get(rootVal); //直接从map里面取【节省了每次递归都遍历一次的时间】
//        for (int i = inStart; i < inorder.length; i++) {
//            if (inorder[i] == rootVal) { //从中序遍历中寻找root节点的index
//                index = i;
//                break;
//            }
//        }
        TreeNode root = new TreeNode(rootVal);
        int leftSize = index - inStart; //算出root节点左边的大小
        root.left = dfs(inorder, inStart, index - 1, postorder, pStart, pStart + leftSize - 1);
        root.right = dfs(inorder, index + 1, inEnd, postorder, pStart + leftSize, pEnd - 1);
        return root;
    }
}
