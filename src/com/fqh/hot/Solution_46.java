package com.fqh.hot;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 海盗狗
 * @version 1.0
 * 46. 全排列
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 */
public class Solution_46 {

    public static void main(String[] args) {

        int[] nums = {1, 2, 3};
        List<List<Integer>> permute = permute(nums);

        System.out.println(permute);
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backtrack(nums, res, list);

        return res;
    }

    public static void backtrack(int[] nums, List<List<Integer>> res, List<Integer> list) {
//        到达叶子节点
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
//            排除不合法的选择
            if (list.contains(nums[i])) {
                continue;
            }
//            做选择
            list.add(nums[i]);
//            进入下一层决策树
            backtrack(nums, res, list);
//            撤销选择
            list.remove(list.size() - 1);
        }
    }
}
