package com.fqh.week_race.week_313;

/**
 * @author The End of Death
 * @version 1.0
 * @since 2022/10/6 19:25:29
 */

/**
 * 2.沙漏的最大总和
 * 给你一个大小为 m x n 的整数矩阵 grid 。
 *
 * 按以下形式将矩阵的一部分定义为一个 沙漏 ：
 *
 *
 * 返回沙漏中元素的 最大 总和。
 *
 * 注意：沙漏无法旋转且必须整个包含在矩阵中
 * 输入：grid = [[6,2,1,3],[4,2,1,5],[9,2,8,7],[4,1,2,9]]
 * 输出：30
 * 解释：上图中的单元格表示元素总和最大的沙漏：6 + 2 + 1 + 2 + 9 + 2 + 8 = 30 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/maximum-sum-of-an-hourglass
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question2 {

    public static void main(String[] args) {
        int[][] grid = {{6,2,1,3},{4,2,1,5},{9,2,8,7},{4,1,2,9}};
        System.out.println(new Question2().maxSum(grid));
    }

    public int maxSum(int[][] grid) {
        int ans = 0;
        for (int i = 1; i < grid.length - 1; i++) {
            for (int j = 1; j < grid.length - 1; j++) {
                ans = Math.max(ans, grid[i - 1][j - 1] + grid[i - 1][j] + grid[i - 1][j + 1] + grid[i][j] + grid[i + 1][j - 1] + grid[i + 1][j] + grid[i + 1][j + 1]);
            }
        }
        return ans;
    }
}
