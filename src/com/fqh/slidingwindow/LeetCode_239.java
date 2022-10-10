package com.fqh.slidingwindow;

/**
 * @author The End of Death
 * @version 1.0
 * @since 2022/9/23 22:52:05
 */

import java.util.*;

/**
 * 239. 滑动窗口最大值
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * <p>
 * 返回 滑动窗口中的最大值 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/sliding-window-maximum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_239 {

    public static void main(String[] args) {

        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
//    int[] nums = {1, -1};
        int k = 3;
        System.out.println(Arrays.toString(new LeetCode_239().maxSlidingWindow(nums, k)));
    }

    // 单调队列
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length < 2) {
            return nums;
        }
        Deque<Integer> deque = new ArrayDeque<>();
        int index = 0;
        int[] ans = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            // 保证从大到小 如果前面数小则需要依次弹出，直至满足要求
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollFirst();
            }
            deque.addLast(i);
            // 判断当前队列中队首的值是否有效
            if (deque.peek() <= i - k) {
                deque.poll();
            }
            //
            if (i >= k - 1) {
                ans[index++] = nums[deque.peek()];
            }
        }
        return ans;
    }

}
