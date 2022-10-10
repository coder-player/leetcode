package com.fqh.hot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 我劝你荔枝_FQH
 * @version 1.0
 * Date: 2022/6/6 23:22:03
 * 448. 找到所有数组中消失的数字
 * 给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数字，并以数组的形式返回结果。
 * 输入：nums = [4,3,2,7,8,2,3,1]
 * 输出：[5,6]
 */
public class Solution_448 {

    public static void main(String[] args) {

        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};

        System.out.println(findDisappearedNumbers(nums));
    }

    /**
     * 将当前索引的val取出来--->去指定索引(val)位置将它的值设置为负数
     */
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int val;
            if (nums[i] < 0) { //当前的val被设置为负数
                val = nums[i]; //拿到它的绝对值去设置索引为val - 1的值
                val = Math.abs(val) - 1;
            } else {
                val = nums[i] - 1;
            }
            if (nums[val] < 0) { //如果当前[val]索引的值已经是负数了就没必要再设置
                continue;
            }
            nums[val] = -nums[val]; //将索引位置【val】的值设置为负数
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                res.add(i + 1); //找到值>0的数的索引 + 1
            }
        }
        return res;
    }
}
