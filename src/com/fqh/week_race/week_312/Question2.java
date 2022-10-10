package com.fqh.week_race.week_312;

/**
 * @author The End of Death
 * @version 1.0
 * @since 2022/10/6 22:21:06
 */

/**
 * 2.按位与最大的最长子数组
 * 输入：nums = [1,2,3,3,2,2]
 * 输出：2
 * 解释：
 * 子数组按位与运算的最大值是 3 。
 * 能得到此结果的最长子数组是 [3,3]，所以返回 2 。
 */
public class Question2 {

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4};
        System.out.println(new Question2().longestSubarray(nums));
    }

    public int longestSubarray(int[] nums) {
        int maxx = 0;
        for (int num : nums) {
            maxx = Math.max(maxx, num);
        }
        int ans = 0;
        int curr = 0;
        for (int num : nums) {
            if (num == maxx) {
                curr++;
                ans = Math.max(ans, curr);
            } else {
                curr = 0;
            }
        }
        return ans;
    }

}
