package com.fqh.codetop;

import java.util.Arrays;

/**
 * @author 海盗狗
 * @version 1.0
 * 200. 岛屿数量
 * 输入：grid = [
 * ["1","1","1","1","0"],
 * ["1","1","0","1","0"],
 * ["1","1","0","0","0"],
 * ["0","0","0","0","0"]
 * ]
 * 输出：1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-islands
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_200 {

    static int num = 0;

    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        System.out.println(numIslands(grid));
    }

    public static int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    num++;
                }
            }
        }
        return num;
    }

    //    dfs
    public static void dfs(char[][] grid, int row, int col) {
//        边界判断
        if (row < 0 || row > grid.length - 1 || col < 0 || col > grid[0].length - 1) {
            return;
        }
        if (grid[row][col] == '0') {
            return;
        }
//        相邻的'1'---->'0'
        grid[row][col] = '0';
        dfs(grid, row - 1, col);
        dfs(grid, row, col + 1);
        dfs(grid, row + 1, col);
        dfs(grid, row, col - 1);
    }
}
