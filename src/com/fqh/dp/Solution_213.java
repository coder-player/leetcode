package com.fqh.dp;

import java.util.Arrays;

/**
 * @author The End of Death
 * @version 1.0
 * @since 2022/9/28 13:28:52
 */

/**
 * 213. 打家劫舍 II
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 * <p>
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,3,2]
 * 输出：3
 * 解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/house-robber-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_213 {

    public static void main(String[] args) {
        int[] nums = {2, 3, 2};
        System.out.println(new Solution_213().rob(nums));
    }

    // 将数组拆分成0 - len-1 和 1 - len
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(
                help(Arrays.copyOfRange(nums, 0, nums.length - 1)),
                help(Arrays.copyOfRange(nums, 1, nums.length)));
    }

    public int help(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int n = nums.length;
        int[] dp = new int[n];
        int max = Math.max(nums[0], nums[1]);
        dp[0] = nums[0];
        dp[1] = max;
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[n - 1];
    }
}
