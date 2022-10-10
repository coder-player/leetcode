package com.fqh.double_pointer;

import java.util.Arrays;

/**
 * @author The End of Death
 * @version 1.0
 * @since 2022/10/6 14:50:53
 */
public class LeetCode_287 {

    public static void main(String[] args) {

        int[] nums = {3, 1, 3, 4, 2};
        System.out.println(new LeetCode_287().findDuplicate(nums));
    }

    // 链表指针解法
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        slow = nums[slow];
        fast = nums[nums[fast]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
