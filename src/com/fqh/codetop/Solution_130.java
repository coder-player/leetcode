package com.fqh.codetop;

/**
 * @author 我劝你荔枝_FQH
 * @version 1.0
 * Date: 2022/6/9 09:09:10
 * 130. 被围绕的区域
 * 给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 * 输入：board = [
 * ["X","X","X","X"],
 * ["X","O","O","X"],
 * ["X","X","O","X"],
 * ["X","O","X","X"]
 * ]
 * 输出：[
 * ["X","X","X","X"],
 * ["X","X","X","X"],
 * ["X","X","X","X"],
 * ["X","O","X","X"]]
 * 解释：被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/surrounded-regions
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_130 {


    public static void main(String[] args) {
    }

    public static void solve(char[][] board) {

        int m = board.length;
        int n = board[0].length;
//        将四周有’O’的和‘O’相连的全部染成'-'
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                dfs(board, i, 0);
            }
            if (board[i][n - 1] == 'O') {
                dfs(board, i, n - 1);
            }
        }
        for (int i = 0; i < n; i++) {
            if (board[0][i] == 'O') {
                dfs(board, 0, i);
            }
            if (board[m - 1][i] == 'O') {
                dfs(board, m - 1, i);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 将里面的还有'O'的染成‘X’
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                    continue;
                }
//                将所以的‘-’还原
                if (board[i][j] == '-') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    public static void dfs(char[][] board, int row, int col) {
        if (row < 0 || row > board.length - 1 || col < 0 || col > board[0].length - 1) {
            return;
        }
        if (board[row][col] == 'X' || board[row][col] == '-') {
            return;
        }
        board[row][col] = '-';
        dfs(board, row - 1, col);
        dfs(board, row, col + 1);
        dfs(board, row + 1, col);
        dfs(board, row, col - 1);
    }
}
