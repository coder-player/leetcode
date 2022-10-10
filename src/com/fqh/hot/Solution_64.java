package com.fqh.hot;

import java.util.Arrays;

/**
 * @author 海盗狗
 * @version 1.0
 * 64. 最小路径和 (动态规划)
 * 输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
 * 输出：7
 * 解释：因为路径 1→3→1→1→1 的总和最小。
 */
public class Solution_64 {

    public static void main(String[] args) {

        int[][] grid = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };

        System.out.println(minPathSum(grid));
    }

    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
//        初始化第一行
        for (int i = 0; i < m; i++) {
            if (i > 0) {
                dp[i][0] = grid[i][0] + dp[i - 1][0];
            } else {
                dp[i][0] = grid[i][0];
            }
        }
//        初始化第一列
        for (int i = 0; i < n; i++) {
            if (i > 0) {
                dp[0][i] = grid[0][i] + dp[0][i - 1];
            } else {
                dp[0][i] = grid[0][i];
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
//                在从上面到当前位置 和 从左边到当前位置取一个最小值(状态转移方程)
                dp[i][j] = Math.min(dp[i - 1][j] + grid[i][j], dp[i][j - 1] + grid[i][j]);
            }
        }
        return dp[m - 1][n - 1];
    }
}
