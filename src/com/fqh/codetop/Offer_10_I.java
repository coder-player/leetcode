package com.fqh.codetop;

/**
 * @author 海盗狗
 * @version 1.0
 * 剑指 Offer 10- I. 斐波那契数列
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 * <p>
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 输入：n = 5
 * 输出：5
 */
public class Offer_10_I {

    public static void main(String[] args) {

        int n = 51;
        System.out.println(fib(n));
    }

    public static int fib(int n) {
        //缓存，避免递归过程中重复计算
        int[] arr = new int[n + 1];
        return dp(arr, n);
    }

    public static int dp(int[] arr, int n) {
        if (n < 2) { //n = 0, return 0; n = 1, return 1
            return n;
        }
        if (arr[n] != 0) { //这里arr[n] != 0就说明之前计算过arr[n], 直接返回
            return arr[n] % 1000000007;
        }
        arr[n] = dp(arr, n - 1) + dp(arr, n - 2);
        return arr[n] % 1000000007;
    }
}
