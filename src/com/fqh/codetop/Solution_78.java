package com.fqh.codetop;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 海盗狗
 * @version 1.0
 * 78. 子集
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * <p>
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 */
public class Solution_78 {

    public static void main(String[] args) {

        int[] nums = {1, 2, 3};
        System.out.println(subsets(nums));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backtrack(nums, res, list, 0);
        return res;
    }

    //    回溯模板
    public static void backtrack(int[] nums, List<List<Integer>> res, List<Integer> list, int start) {
        res.add(new ArrayList<>(list));
        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]); //做选择
            backtrack(nums, res, list, i + 1); //i+1防止元素重复
            list.remove(list.size() - 1); //撤销选择
        }
    }
}
