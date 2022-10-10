package com.fqh.codetop;

import java.util.Arrays;

/**
 * @author 我劝你荔枝_FQH
 * @version 1.0
 * Date: 2022/4/29 23:58:49
 * 283. 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 * 示例 1:
 * <p>
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 */
public class Solution_283 {

    public static void main(String[] args) {

        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void moveZeroes(int[] nums) {
        int slow = 0; //维护slow之前的元素全是非零元素
        int fast = 0;
        while (fast < nums.length) {
            //fast指针不停的移动遇到非0元素就把值给slow所在的位置
            if (nums[fast] != 0) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        //将slow之后的元素置0
        while (slow < nums.length) {
            nums[slow++] = 0;
        }
    }
}
