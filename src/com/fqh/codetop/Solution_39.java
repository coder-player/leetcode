package com.fqh.codetop;

import sun.nio.cs.ext.IBM037;

import java.util.*;

/**
 * @author 海盗狗
 * @version 1.0
 * 39. 组合总和
 * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
 * <p>
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。 
 * <p>
 * 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 输入：candidates = [2,3,6,7], target = 7
 * 输出：[[2,2,3],[7]]
 * 解释：
 * 2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
 * 7 也是一个候选， 7 = 7 。
 * 仅有这两种组合。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_39 {

    public static void main(String[] args) {

        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> combinationSum = combinationSum(candidates, target);
        System.out.println(combinationSum);
    }

    static int num = 0; //递归过程中累加
    static List<List<Integer>> res = new ArrayList<>();

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> list = new ArrayList<>();
        backtrack(candidates, list, target, 0);
        return res;
    }

    public static void backtrack(int[] candidates, List<Integer> list, int target, int start) {
//        找到一种组合
        if (num == target) {
            res.add(new ArrayList<>(list));
            return;
        }
//        累加的值大于了target
        if (num > target) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            list.add(candidates[i]); //选择
            num += candidates[i];
            backtrack(candidates, list, target, i);
            list.remove(list.size() - 1); //撤销选择
            num -= candidates[i];
        }
    }
}
