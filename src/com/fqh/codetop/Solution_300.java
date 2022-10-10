package com.fqh.codetop;

import java.util.Arrays;

/**
 * @author 我劝你荔枝_FQH
 * @version 1.0
 * Date: 2022/5/28 23:06:11
 * 300. 最长递增子序列 [动态规划]
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * <p>
 * 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/longest-increasing-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 输入：nums = [10,9,2,5,3,7,101,18]
 * 输出：4
 * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
 */
public class Solution_300 {

    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(lengthOfLIS(nums));
    }

    //动态规划
    public static int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        //base-case
        Arrays.fill(dp, 1);

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) { //将i固定,循环遍历nums[i]前面的数据
                //找到一个小于nums[i]的,就更新dp数组
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int res = 0;
        for (int i : dp) {
            res = Math.max(res, i);
        }
        return res;
    }
}
