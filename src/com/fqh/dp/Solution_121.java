package com.fqh.dp;

/**
 * @author 我劝你荔枝_FQH
 * @version 1.0
 * Date: 2022/7/11 22:42:41
 * 121. 买卖股票的最佳时机
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * <p>
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * <p>
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：[7,1,5,3,6,4]
 * 输出：5
 * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/best-time-to-buy-and-sell-stock
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_121 {

    public static void main(String[] args) {

        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
    }

    /**
     * ****************
     * 执行结果：
     * 通过
     * 执行用时：4 ms, 在所有 Java 提交中击败了25.78% 的用户 TODO
     * 内存消耗：51.8 MB, 在所有 Java 提交中击败了97.76% 的用户
     * 通过测试用例：211 / 211
     * *****************
     */
    //动态规划
    public static int maxProfit(int[] prices) {
        int[] dp = new int[prices.length];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                dp[i] = Math.max(0, dp[i - 1] + prices[i] - prices[i - 1]);
            } else if (prices[i] < prices[i - 1]) {
                dp[i] = Math.max(0, dp[i - 1] - (prices[i - 1] - prices[i]));
            } else {
                dp[i] = dp[i - 1];
            }
        }
        int maxPrice = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++) {
            maxPrice = Math.max(maxPrice, dp[i]);
        }
        return maxPrice;
//        int max = 0;
//        int min = prices[0];
//        for (int i = 1; i < prices.length; i++) {
//            max = Math.max(max, prices[i] - min);
//            min = Math.min(min, prices[i]);
//        }
//        return max;
    }
}
