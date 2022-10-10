package com.fqh.codetop;

/**
 * @author 海盗狗
 * @version 1.0
 * 74. 搜索二维矩阵
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * <p>
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-a-2d-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * 输出：true
 */
public class Solution_74 {

    public static void main(String[] args) {

        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };
        int target = 30;
        System.out.println(searchMatrix(matrix, target));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
//        还是从右上角出发
        int row = 0;
        int col = matrix[0].length - 1;
        return dfs(matrix, row, col, target);
    }

    public static boolean dfs(int[][] matrix, int row, int col, int target) {
        if (row > matrix.length - 1 || col < 0) {
            return false;
        }
        if (target > matrix[row][col]) { //target大于当前值就往下一行搜索
            return dfs(matrix, row + 1, col, target);
        } else if (target < matrix[row][col]) { //target小于当前值就往前一列搜索
            return dfs(matrix, row, col - 1, target);
        } else {
            return true;
        }
    }
}
