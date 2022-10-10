package com.fqh.hot;

/**
 * @author 我劝你荔枝_FQH
 * @version 1.0
 * Date: 2022/6/26 21:13:12
 * 209. 长度最小的子数组
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 * <p>
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 */
public class Solution_209 {

    public static void main(String[] args) {

        int[] nums = {2, 3, 1, 2, 4, 3};
        int target = 7;
        System.out.println(minSubArrayLen(target, nums));
    }

    //滑窗
    public static int minSubArrayLen(int target, int[] nums) {
        int res = Integer.MAX_VALUE;
        int j = 0; //滑窗左指针
        int sum = 0; //子数组和
        int i; //滑窗右指针
        for (i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= target) { //开始缩小左窗口
                int minLen = i - j + 1; //最小子数组长度
                res = Math.min(res, minLen);
                sum -= nums[j];
                j++; //缩小窗口
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
