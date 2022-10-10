package com.fqh.codetop;

import com.fqh.util.TreeNode;

/**
 * @author 我劝你荔枝
 * @version 1.0
 * Date: 2022/4/27 22:46:43
 * 129. 求根节点到叶节点数字之和
 * 给你一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
 * 每条从根节点到叶节点的路径都代表一个数字：
 * <p>
 * 例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
 * 计算从根节点到叶节点生成的 所有数字之和 。
 * <p>
 * 叶节点 是指没有子节点的节点。
 * 输入：root = [4,9,0,5,1]
 * 输出：1026
 * 解释：
 * 从根到叶子节点路径 4->9->5 代表数字 495
 * 从根到叶子节点路径 4->9->1 代表数字 491
 * 从根到叶子节点路径 4->0 代表数字 40
 * 因此，数字总和 = 495 + 491 + 40 = 1026
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-root-to-leaf-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_129 {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        System.out.println(sumNumbers(root));
    }

    public static int sumNumbers(TreeNode root) {
        dfs(root, 0);
        return sum;
    }

    //    static String pathVal = "";
    static int sum = 0;

    public static int dfs(TreeNode root, int pathVal) {
        if (root == null) {
            return pathVal;
        }
        pathVal = pathVal * 10 + root.val; //1 * 10 + 2 => 12, 1 * 10 = 3 => 13
        if (root.left == null && root.right == null) {
            //叶子节点，把pathVal累加到sum
            sum += pathVal;
        }
        dfs(root.left, pathVal);
        dfs(root.right, pathVal);
        return sum;
    }
}
