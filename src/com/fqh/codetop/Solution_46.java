package com.fqh.codetop;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 海盗狗
 * @version 1.0
 * 46.全排列
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 */
public class Solution_46 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(permute(nums));
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backtrack(nums, res, list);
        return res;
    }

    //    回溯
    public static void backtrack(int[] nums, List<List<Integer>> res, List<Integer> list) {
        if (list.size() == nums.length) { //找到一个排列
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i])) { //排列中有重复的就跳过
                continue;
            }
            list.add(nums[i]); //选择
            backtrack(nums, res, list); //进入下一层
            list.remove(list.size() - 1); //撤销选择
        }
    }

}
