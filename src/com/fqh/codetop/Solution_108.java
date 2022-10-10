package com.fqh.codetop;

import com.fqh.util.TreeNode;

/**
 * @author 我劝你荔枝_FQH
 * @version 1.0
 * Date: 2022/6/17 23:15:24
 * 108. 将有序数组转换为二叉搜索树
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
 * <p>
 * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/convert-sorted-array-to-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 输入：nums = [-10,-3,0,5,9]
 * 输出：[0,-3,9,-10,null,5]
 * 解释：[0,-10,5,null,-3,null,9] 也将被视为正确答案：
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/convert-sorted-array-to-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_108 {

    public static void main(String[] args) {

        int[] nums = {-10, -3, 0, 5, 9};
        TreeNode root = sortedArrayToBST(nums);
        System.out.println(root);
    }

    //dfs递归
    public static TreeNode sortedArrayToBST(int[] nums) {
        return dfs(nums, 0, nums.length - 1);
    }

    public static TreeNode dfs(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        //因为数组是有序的--->选取中间元素当作根
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        //递归构建左右子树
        root.left = dfs(nums, left, mid - 1);
        root.right = dfs(nums, mid + 1, right);
        return root;
    }
}
