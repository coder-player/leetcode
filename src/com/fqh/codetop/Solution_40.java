package com.fqh.codetop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 我劝你荔枝_FQH
 * @version 1.0
 * Date: 2022/6/2 23:08:42
 * 40. 组合总和 II
 * 给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的每个数字在每个组合中只能使用 一次 。
 * <p>
 * 注意：解集不能包含重复的组合。
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 输出:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/combination-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_40 {

    public static void main(String[] args) {

        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        List<List<Integer>> lists = combinationSum2(candidates, target);
        System.out.println(lists);
    }


    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Arrays.sort(candidates); //将数组排序，让相同的值排在一起
        backtrack(candidates, 0, target, res, path);
        return res;
    }

    static int sum = 0; //路径累加和

    /**
     * ****************
     * 回溯模板
     * *****************
     */
    public static void backtrack(int[] candidates, int start,
                                 int target, List<List<Integer>> res,
                                 List<Integer> path) {
        if (sum == target) { //找到一个合适的组合
            res.add(new ArrayList<>(path));
            return;
        }
        if (sum > target) { //大于目标值，返回
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            // 如果当前元素等于前面的元素，进行剪枝，不选择
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            path.add(candidates[i]); //做选择
            sum += candidates[i];
            backtrack(candidates, i + 1, target, res, path);  //进入下一层决策树
            sum -= candidates[i]; //撤销选择
            path.remove(path.size() - 1);
        }
    }
}
