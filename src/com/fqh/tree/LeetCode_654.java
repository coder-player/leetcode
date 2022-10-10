package com.fqh.tree;

/**
 * @author The End of Death
 * @version 1.0
 * @since 2022/9/20 23:16:11
 */

import com.fqh.util.TreeNode;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 654. 最大二叉树
 * 给定一个不重复的整数数组 nums 。 最大二叉树 可以用下面的算法从 nums 递归地构建:
 * <p>
 * 创建一个根节点，其值为 nums 中的最大值。
 * 递归地在最大值 左边 的 子数组前缀上 构建左子树。
 * 递归地在最大值 右边 的 子数组后缀上 构建右子树。
 * <p>
 * 返回 nums 构建的 最大二叉树 。
 * 输入：nums = [3,2,1,6,0,5]
 * 输出：[6,3,5,null,2,0,null,null,1]
 * 解释：递归调用如下所示：
 * - [3,2,1,6,0,5] 中的最大值是 6 ，左边部分是 [3,2,1] ，右边部分是 [0,5] 。
 * - [3,2,1] 中的最大值是 3 ，左边部分是 [] ，右边部分是 [2,1] 。
 * - 空数组，无子节点。
 * - [2,1] 中的最大值是 2 ，左边部分是 [] ，右边部分是 [1] 。
 * - 空数组，无子节点。
 * - 只有一个元素，所以子节点是一个值为 1 的节点。
 * - [0,5] 中的最大值是 5 ，左边部分是 [0] ，右边部分是 [] 。
 * - 只有一个元素，所以子节点是一个值为 0 的节点。
 * - 空数组，无子节点。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/maximum-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_654 {

    public static void main(String[] args) {

        int[] nums = {3, 2, 1, 6, 0, 5};
        TreeNode root = new LeetCode_654().constructMaximumBinaryTree(nums);
        System.out.println(root);
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return dfs(nums, 0, nums.length - 1);
    }

    //DFS
    public TreeNode dfs(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int max = Integer.MIN_VALUE;
        int index = 0;
        for (int i = start; i <= end; i++) {
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }
        TreeNode root = new TreeNode(max);
        root.left = dfs(nums, start, index - 1);
        root.right = dfs(nums, index + 1, end);
        return root;
    }
}
