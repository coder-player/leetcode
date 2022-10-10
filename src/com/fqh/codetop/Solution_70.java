package com.fqh.codetop;

/**
 * @author 海盗狗
 * @version 1.0
 * 70. 爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 输入：n = 2
 * 输出：2
 * 解释：有两种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶
 * 2. 2 阶
 */
public class Solution_70 {

    public static void main(String[] args) {
        int n = 3;
        System.out.println(climbStairs(n));
    }

    public static int climbStairs(int n) {
//        构建备忘录，避免递归过程的重复计算
        int[] arr = new int[n + 1];
        return dp(arr, n);
    }

    public static int dp(int[] arr, int n) {
//        if (n == 1) {
//            return 1;
//        }
//        if (n == 2) {
//            return 2;
//        }
        if (n <= 2) {
            return n;
        }
        if (arr[n] != 0) {
            return arr[n];
        }
//        爬到第 n 级台阶的方法个数等于爬到 n - 1 的方法个数和爬到 n - 2 的方法个数之和
        arr[n] = dp(arr, n - 1) + dp(arr, n - 2);
        return arr[n];
    }
}
