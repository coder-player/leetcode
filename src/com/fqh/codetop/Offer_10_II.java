package com.fqh.codetop;

/**
 * @author 我劝你荔枝_FQH
 * @version 1.0
 * Date: 2022/4/30 00:08:40
 * 剑指 Offer 10- II. 青蛙跳台阶问题
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 * <p>
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 输入：n = 7
 * 输出：21
 */
public class Offer_10_II {

    public static void main(String[] args) {

        int n = 7;
        System.out.println(numWays(n));
    }

    public static int numWays(int n) {
        int[] dp = new int[n + 1]; //定义备忘录【递归过程避免重复计算】
        return dfs(dp, n);
    }

    public static int dfs(int[] dp, int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        //看看备忘录是否计算过了
        if (dp[n] != 0) {
            return dp[n];
        }
        //状态转移方程
        dp[n] = (dfs(dp, n - 1) + dfs(dp, n - 2)) % 1000000007;
        return dp[n];
    }
}
