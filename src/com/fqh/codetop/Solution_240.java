package com.fqh.codetop;

/**
 * @author 海盗狗
 * @version 1.0
 * 240. 搜索二维矩阵 II
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 * <p>
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-a-2d-matrix-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
 * 输出：true
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-a-2d-matrix-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
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
        System.out.println(searchMatrix(matrix, 5));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        int col = matrix[0].length - 1;
//        从左上角出发[像一颗二叉搜索树]
        return dfs(matrix, row, col, target);
    }

    public static boolean dfs(int[][] matrix, int row, int col, int target) {
        if (row > matrix.length - 1 || col < 0) { //边界判断
            return false;
        }
        if (target > matrix[row][col]) { //利用二叉搜索树的特性
            return dfs(matrix, row + 1, col, target);
        } else if (target < matrix[row][col]) {
            return dfs(matrix, row, col - 1, target);
        }
        return true;
    }
}
