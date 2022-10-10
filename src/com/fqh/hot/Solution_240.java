package com.fqh.hot;

/**
 * @author 海盗狗
 * @version 1.0
 * 240. 搜索二维矩阵 II
 * 输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
 * 输出：true
 */
public class Solution_240 {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        int target = 5;

        System.out.println(searchMatrix(matrix, target));

    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
//        从第一行的最后一个元素开始向左右遍历
        int row = 0;
        int col = matrix[0].length - 1;

        return dfs(matrix, row, col, target);
    }

    public static boolean dfs(int[][] matrix, int row, int col, int target) {
//        处理边界
        if (col < 0 || row >= matrix.length) {
            return false;
        }
//        BST
        if (target == matrix[row][col]) {
            return true;
        }
        if (target > matrix[row][col]) {
            return dfs(matrix, row + 1, col, target);
        }
        if (target < matrix[row][col]) {
            return dfs(matrix, row, col - 1, target);
        }
        return false;
    }
}
