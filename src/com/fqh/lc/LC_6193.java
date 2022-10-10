package com.fqh.lc;

/**
 * @author The End of Death
 * @version 1.0
 * @since 2022/10/2 10:31:33
 */
public class LC_6193 {

    public static void main(String[] args) {
        int[][] grid = {
                {6, 2, 1, 3},
                {4, 2, 1, 5},
                {9, 2, 8, 7},
                {4, 1, 2, 9}
//        {1, 2, 3},
//        {4, 5, 6},
//        {7, 8, 9}
        };
        System.out.println(new LC_6193().maxSum(grid));
    }

    int res = 0;

    //AC
    public int maxSum(int[][] grid) {
        for (int i = 1; i < grid.length - 1; i++) {
            for (int j = 1; j < grid[i].length - 1; j++) {
                int l1 = grid[i - 1][j - 1];
                int l2 = grid[i - 1][j];
                int l3 = grid[i - 1][j + 1];
                int l4 = grid[i + 1][j];
                int l5 = grid[i + 1][j - 1];
                int l6 = grid[i + 1][j + 1];
                int val = l1 + l2 + l3 + l4 + l5 + l6 + grid[i][j];
                res = Math.max(res, val);
            }
        }
        return res;
    }
}
