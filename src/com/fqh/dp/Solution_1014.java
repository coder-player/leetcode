package com.fqh.dp;

/**
 * @author The End of Death
 * @version 1.0
 * @since 2022/9/29 14:08:39
 */
public class Solution_1014 {

    public static void main(String[] args) {

        int[] values = {1, 2};
        System.out.println(new Solution_1014().maxScoreSightseeingPair(values));
    }

    //TODO 超时
    public int maxScoreSightseeingPair(int[] values) {
        int n = values.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                dp[i] = Math.max(dp[i], values[i] + values[j] + i - j);
            }
        }
        int max = Integer.MIN_VALUE;

        return -1;
    }
}
