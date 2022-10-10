package com.fqh.codetop;

import com.fqh.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 我劝你荔枝_FQH
 * @version 1.0
 * Date: 2022/5/31 00:15:05
 * 113. 路径总和 II
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 * <p>
 * 叶子节点 是指没有子节点的节点。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/path-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * 输出：[[5,4,11,2],[5,8,4,5]]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/path-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_113 {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(5);
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(8);
        TreeNode node3 = new TreeNode(11);
        TreeNode node4 = new TreeNode(13);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(7);
        TreeNode node7 = new TreeNode(2);
        TreeNode node8 = new TreeNode(5);
        TreeNode node9 = new TreeNode(1);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node5.left = node8;
        node5.right = node9;

        int targetSum = 22;
        List<List<Integer>> pathSum = pathSum(root, targetSum);
        System.out.println(pathSum);
    }

    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> resultList = new ArrayList<>();
        List<Integer> list = new ArrayList<>(); //存储一条路径

        dfs(root, resultList, list, targetSum);
        return resultList;
    }

    //dfs
    public static void dfs(TreeNode root, List<List<Integer>> resultList, List<Integer> list, int target) {
        if (root == null) {
            return;
        }
        list.add(root.val); //将节点值加入到list
        if (root.left == null && root.right == null) { //叶子节点
            if (target - root.val == 0) {   //如果target - 节点的值 = 0; 说明是一条路
                resultList.add(new ArrayList<>(list)); //就new一个list放入list
            }
            return;
        }
        //在递归过程中堆targetSum累减
        if (root.left != null) {
            dfs(root.left, resultList, list, target - root.val);
            list.remove(list.size() - 1); //撤销选择
        }
        if (root.right != null) {
            dfs(root.right, resultList, list, target - root.val);
            list.remove(list.size() - 1);
        }
    }
}
