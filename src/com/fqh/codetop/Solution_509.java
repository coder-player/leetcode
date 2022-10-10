package com.fqh.codetop;

/**
 * @author 我劝你荔枝_FQH
 * @version 1.0
 * Date: 2022/5/1 12:46:58
 * 509. 斐波那契数
 * 斐波那契数 （通常用 F(n) 表示）形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 * <p>
 * F(0) = 0，F(1) = 1
 * F(n) = F(n - 1) + F(n - 2)，其中 n > 1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fibonacci-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 输入：n = 3
 * 输出：2
 * 解释：F(3) = F(2) + F(1) = 1 + 1 = 2
 */
public class Solution_509 {

    public static void main(String[] args) {

        int n = 4;
        System.out.println(fib(n));
    }

    public static int fib(int n) {
        int[] dp = new int[n + 1]; //备忘录
        return dfs(dp, n);
    }

    //递归 + 备忘录
    public static int dfs(int[] dp, int n) {
        if (n <= 1) {
            return n;
        }
        if (dp[n] != 0) { //计算过的值就直接返回
            return dp[n];
        }
        dp[n] = dfs(dp, n - 1) + dfs(dp, n - 2);
        return dp[n];
    }
}
