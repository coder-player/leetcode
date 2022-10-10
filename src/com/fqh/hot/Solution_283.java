package com.fqh.hot;

import java.util.Arrays;

/**
 * @author 海盗狗
 * @version 1.0
 * 283. 移动零
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 */
public class Solution_283 {

    public static void main(String[] args) {

        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes(nums);
    }

    public static void moveZeroes(int[] nums) {
        int fast = 1;
        int slow = 0;
//        将所有不为0的元素全部移动到slow前面
        while (fast < nums.length) {
            if (nums[fast] != 0) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
//        将slow后面的元素全部置零
        for (int i = slow; i < nums.length; i++) {
            nums[i] = 0;
        }
        System.out.println(Arrays.toString(nums));
    }
}
