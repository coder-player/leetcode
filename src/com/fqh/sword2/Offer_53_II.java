package com.fqh.sword2;

import java.util.Arrays;

/**
 * @author 我劝你荔枝_FQH
 * @version 1.0
 * Date: 2022/7/3 00:18:17
 * 剑指 Offer 53 - II. 0～n-1中缺失的数字
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 * <p>
 * 示例 2:
 * <p>
 * 输入: [0,1,2,3,4,5,6,7,9]
 * 输出: 8
 */
public class Offer_53_II {

    public static void main(String[] args) {

        int[] nums = {0, 1, 3};
        System.out.println(missingNumber(nums));
    }


    //TODO O(logN)
    public static int missingNumber(int[] nums) {

        return binarySearch(nums, 0, nums.length - 1);
    }

    public static int binarySearch(int[] nums, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            if (nums[mid] != mid) {
                return binarySearch(nums, low, mid - 1);
            } else {
                return binarySearch(nums, mid + 1, high);
            }
        }
        return low;
    }
}
