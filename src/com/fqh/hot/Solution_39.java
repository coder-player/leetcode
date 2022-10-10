package com.fqh.hot;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 海盗狗
 * @version 1.0
 * 39.组合总和
 * 输入：candidates = [2,3,6,7], target = 7
 * 输出：[[2,2,3],[7]]
 * 解释：
 * 2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
 * 7 也是一个候选， 7 = 7 。
 * 仅有这两种组合。
 */
public class Solution_39 {

    public static void main(String[] args) {

        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> combinationSum = combinationSum(candidates, target);

        System.out.println(combinationSum);
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backtrack(candidates, target, res, list, 0);

        return res;
    }

    public static void backtrack(int[] candidates, int target, List<List<Integer>> res, List<Integer> list, int start) {
//        list的和等于target 是一个正确组合
        if (sum(list) == target) {
            res.add(new ArrayList<>(list));
            return;
        }
//        从start开始走
        for (int i = start; i < candidates.length; i++) {
//            如果当前list的和加上一个元素 > target 就不合法
            if (sum(list) + candidates[i] > target) {
                continue;
            }
            list.add(candidates[i]);
            backtrack(candidates, target, res, list, i);
            list.remove(list.size() - 1);
        }

    }

    public static int sum(List<Integer> list) {
        int sum = 0;
        for (int i : list) {
            sum += i;
        }
        return sum;
    }
}
