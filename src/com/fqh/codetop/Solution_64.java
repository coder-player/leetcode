package com.fqh.codetop;

import java.util.Arrays;

/**
 * @author 我劝你荔枝_FQH
 * @version 1.0
 * Date: 2022/5/6 22:44:17
 * 64. 最小路径和
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * <p>
 * 说明：每次只能向下或者向右移动一步。
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

    //动态规划
    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        //初始化dp数组
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        //初始化第一行
        for (int i = 1; i < n; i++) {
            dp[0][i] = grid[0][i] + dp[0][i - 1];
        }
        //初始化第一列
        for (int i = 1; i < m; i++) {
            dp[i][0] = grid[i][0] + dp[i - 1][0];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                //这里是判断当前grid[i][j]的值跟从上面走过来dp[i - 1][j]和从左面从过来dp[i][j - 1]哪个小
                //状态转移
                dp[i][j] = Math.min(grid[i][j] + dp[i - 1][j], grid[i][j] + dp[i][j - 1]);
            }
        }
        return dp[m - 1][n - 1];
    }
}
