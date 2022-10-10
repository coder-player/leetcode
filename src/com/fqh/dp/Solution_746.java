package com.fqh.dp;


/**
 * @author The End of Death
 * @version 1.0
 * @since 2022/9/29 11:45:48
 */

/**
 * 746. 使用最小花费爬楼梯
 * 给你一个整数数组 cost ，其中 cost[i] 是从楼梯第 i 个台阶向上爬需要支付的费用。一旦你支付此费用，即可选择向上爬一个或者两个台阶。
 * <p>
 * 你可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯。
 * <p>
 * 请你计算并返回达到楼梯顶部的最低花费。
 * 输入：cost = [10,15,20]
 * 输出：15
 * 解释：你将从下标为 1 的台阶开始。
 * - 支付 15 ，向上爬两个台阶，到达楼梯顶部。
 * 总花费为 15 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/min-cost-climbing-stairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_746 {

    public static void main(String[] args) {

        int[] cost = {10, 15, 20};
        System.out.println(new Solution_746().minCostClimbingStairs(cost));
    }

    /**
     * AC
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
     * 内存消耗：40.9 MB, 在所有 Java 提交中击败了81.34% 的用户
     * 通过测试用例：283 / 283
     */
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 2];
        int[] arr = new int[cost.length + 2];
        // arr[起点, 10, 15, 20, 终点]
        for (int i = 1; i < arr.length - 1; i++) {
            arr[i] = cost[i - 1];
        }
        dp[1] = arr[1];
        dp[2] = arr[2];
        for (int i = 3; i < arr.length; i++) {
            dp[i] = Math.min(dp[i - 1] + arr[i], dp[i - 2] + arr[i]);
        }
        return dp[dp.length - 1];
    }
}
