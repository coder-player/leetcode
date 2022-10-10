package com.fqh.hot;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 海盗狗
 * @version 1.0
 * 78. 子集
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 */
public class Solution_78 {

    public static void main(String[] args) {

        int[] nums = {1, 2, 3};
        List<List<Integer>> subsets = subsets(nums);
        System.out.println(subsets);
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backtrack(nums, 0, res, list);

        return res;
    }

    public static void backtrack(int[] nums, int start, List<List<Integer>> res, List<Integer> list) {
        res.add(new ArrayList<>(list));
//        从start 开始, 防止产生重复的子集
        for (int i = start; i < nums.length; i++) {
//            做选择
            list.add(nums[i]);
//            递归回溯
            backtrack(nums, i + 1, res, list);
//            撤销选择
            list.remove(list.size() - 1);
        }
    }

}
