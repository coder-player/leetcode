package com.fqh.codetop;


/**
 * @author 我劝你荔枝_FQH
 * @version 1.0
 * Date: 2022/6/26 22:25:24
 * 53. 最大子数组和
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 子数组 是数组中的一个连续部分。
 * 示例 1：
 * <p>
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/maximum-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_53 {

    public static void main(String[] args) {

        int[] nums = {5, 4, -1, 7, 8};
        System.out.println(maxSubArray(nums));
    }

    //动态规划
    public static int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int res = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            //和别人一组 or 自己一组 谁的和大?
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
        }
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
