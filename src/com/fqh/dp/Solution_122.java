package com.fqh.dp;

import java.util.Arrays;

/**
 * @author 我劝你荔枝_FQH
 * @version 1.0
 * Date: 2022/7/11 23:55:41
 * 122. 买卖股票的最佳时机 II
 * 给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。
 * <p>
 * 在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
 * <p>
 * 返回 你能获得的 最大 利润 。
 * <p>
 * <p>
 * 输入：prices = [7,1,5,3,6,4]
 * 输出：7
 * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5 - 1 = 4 。
 * 随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6 - 3 = 3 。
 * 总利润为 4 + 3 = 7 。
 * <p>
 * 示例 2：
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_122 {

    public static void main(String[] args) {

        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
    }

    //TODO
    public static int maxProfit(int[] prices) {
        int[] dp = new int[prices.length];
        int maxPrice = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                dp[i] = Math.max(0, dp[i - 1] + prices[i] - prices[i - 1]);
//                maxPrice += dp[i];
                maxPrice = dp[i];
            } else if (prices[i] < prices[i - 1]) {
                dp[i] = Math.max(0, dp[i - 1] - (prices[i - 1] - prices[i]));
                maxPrice += dp[i - 1] - prices[i];
            } else {
                dp[i] = dp[i - 1];
            }
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
