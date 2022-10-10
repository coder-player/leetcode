package com.fqh.week_race.week_312;

/**
 * @author The End of Death
 * @version 1.0
 * @since 2022/10/6 22:30:03
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 3.找到所有好下标
 * 给你一个大小为 n 下标从 0 开始的整数数组 nums 和一个正整数 k 。
 *
 * 对于 k <= i < n - k 之间的一个下标 i ，如果它满足以下条件，我们就称它为一个 好 下标：
 *
 * 下标 i 之前 的 k 个元素是 非递增的 。
 * 下标 i 之后 的 k 个元素是 非递减的 。
 * 按 升序 返回所有好下标
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/find-all-good-indices
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question3 {

    public static void main(String[] args) {

        int[] nums = {2, 1, 1, 1, 3, 4, 1};
        int k = 2;
        System.out.println(new Question3().goodIndices(nums, k));
    }

//    输入：nums = [2,1,1,1,3,4,1], k = 2
//    输出：[2,3]
//    解释：数组中有两个好下标：
//            - 下标 2 。子数组 [2,1] 是非递增的，子数组 [1,3] 是非递减的。
//            - 下标 3 。子数组 [1,1] 是非递增的，子数组 [3,4] 是非递减的。
//    注意，下标 4 不是好下标，因为 [4,1] 不是非递减的。
    public List<Integer> goodIndices(int[] nums, int k) {

        // 拆分成左右两个问题
        // 左->右就是统计 递减 的连续子数组的最长长度
        // 右->左就是统计 递增 的连续子数组的最长长度
        // 递推
        // 2 1 1 1 3 4 1
        // left -> right 1 2 3 4 1 1 2
        // right -> left 1 5 4 3 2 1 1
        int n = nums.length;
        int[] dec = new int[n];
        Arrays.fill(dec, 1);
        for (int i = n - 2; i >= k; i--) {
            if (nums[i] <= nums[i + 1])
                dec[i] = dec[i + 1] + 1; // 递推
        }
        int inc = 1;
        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i < n - k; i++) {
            if (inc >= k && dec[i + 1] >= k) {
                ans.add(i);
            }
            if (nums[i - 1] >= nums[i]) {
                inc += 1;
            } else {
                inc = 1;

            }
        }
        return ans;
    }

}
