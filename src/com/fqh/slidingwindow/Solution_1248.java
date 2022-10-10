package com.fqh.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 我劝你荔枝_FQH
 * @version 1.0
 * Date: 2022/7/9 22:53:22
 * 1248. 统计「优美子数组」
 * 给你一个整数数组 nums 和一个整数 k。如果某个连续子数组中恰好有 k 个奇数数字，我们就认为这个子数组是「优美子数组」。
 * <p>
 * 请返回这个数组中 「优美子数组」 的数目。
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/count-number-of-nice-subarrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 输入：nums = [1,1,2,1,1], k = 3
 * 输出：2
 * 解释：包含 3 个奇数的子数组是 [1,1,2,1] 和 [1,2,1,1] 。
 */
public class Solution_1248 {

    public static void main(String[] args) {

        int[] nums = {2, 2, 2, 1, 2, 2, 1, 2, 2, 2};
        int k = 2;
        System.out.println(numberOfSubarrays(nums, k));
    }

    //TODO 需要前缀和知识
    //滑动窗口
    public static int numberOfSubarrays(int[] nums, int k) {

        Map<Integer, Integer> window = new HashMap<>();
        int count = 0;
        int l = 0, r = 0;
        int valid = 0;
        while (r < nums.length) {
            int num = nums[r];
            if (num % 2 == 1) {
                window.put(num, window.getOrDefault(num, 0) + 1);
                valid++;
            }
//            if (valid == k) {
//                count++;
//            }
            r++;
            //缩小窗口
            while (valid == k) {
                count++;
                int num1 = nums[l];
                if (window.containsKey(num1)) {
                    valid--;
                }
                l++;
            }
        }
        return count;
    }
}
