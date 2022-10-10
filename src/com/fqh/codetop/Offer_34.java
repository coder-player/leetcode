package com.fqh.codetop;

import com.fqh.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 我劝你荔枝_FQH
 * @version 1.0
 * Date: 2022/6/5 23:19:23
 * 剑指 Offer 34. 二叉树中和为某一值的路径
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 * <p>
 * 叶子节点 是指没有子节点的节点。
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * 输出：[[5,4,11,2],[5,8,4,5]]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Offer_34 {

    public static void main(String[] args) {
    }

    public static List<List<Integer>> pathSum(TreeNode root, int target) {
        List<List<Integer>> resultPath = new ArrayList<>();
        if (root == null) {
            return resultPath;
        }
        List<Integer> path = new ArrayList<>();
        backtrack(root, target, resultPath, path);
        return resultPath;
    }

    //dfs + 过程对target递减
    public static void backtrack(TreeNode root, int target, List<List<Integer>> resultPath, List<Integer> path) {
        path.add(root.val); //做选择
        if (root.left == null && root.right == null) {
            //如果当前节点是叶子节点 并且 target的值被递减到0
            if (root.val - target == 0) {
                resultPath.add(new ArrayList<>(path)); //找到一条正确的路径
            }
            return;
        }

        //递归过程中对target进行递减
        if (root.left != null) {
            backtrack(root.left, target - root.val, resultPath, path);
            path.remove(path.size() - 1); //撤销选择
        }
        if (root.right != null) {
            backtrack(root.right, target - root.val, resultPath, path);
            path.remove(path.size() - 1); //撤销选择
        }
    }
}
