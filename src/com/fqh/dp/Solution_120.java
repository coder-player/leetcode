package com.fqh.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author The End of Death
 * @version 1.0
 * @since 2022/9/28 20:41:26
 */

/**
 * 120. 三角形最小路径和
 * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
 * <p>
 * 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
 * 输出：11
 * 解释：如下面简图所示：
 * 2
 * 3 4
 * 6 5 7
 * 4 1 8 3
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 */
public class Solution_120 {

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(-1));
        triangle.add(Arrays.asList(2, 3));
        triangle.add(Arrays.asList(1, -1, -3));
//    triangle.add(Arrays.asList(4, 1, 8, 3));
        System.out.println(new Solution_120().minimumTotal(triangle));
    }

    /**
     * AC
     * 执行用时：4 ms, 在所有 Java 提交中击败了33.46% 的用户
     * 内存消耗：41.1 MB, 在所有 Java 提交中击败了58.56% 的用户
     * 通过测试用例：44 / 44
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0] + triangle.get(i).get(0);
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < triangle.get(i).size(); j++) {
                int cur = triangle.get(i).get(j);
                if (dp[i - 1][j] == 0 && j >= triangle.get(i - 1).size()) {
                    dp[i][j] = dp[i - 1][j - 1] + cur;
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j] + cur, dp[i - 1][j - 1] + cur);
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = n - 1, j = 0; j < dp[i].length; j++) {
            ans = Math.min(ans, dp[i][j]);
        }
        return ans;
    }
}
