package com.fqh.codetop;

/**
 * @author 海盗狗
 * @version 1.0
 * 704. 二分查找
 * 输入: nums = [-1,0,3,5,9,12], target = 9
 * 输出: 4
 * 解释: 9 出现在 nums 中并且下标为 4
 */
public class Solution_704 {

    public static void main(String[] args) {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target = 9;
        System.out.println(search(nums, target));
    }

    public static int search(int[] nums, int target) {
//        return binarySearchRecursion(nums, 0, nums.length - 1, target);
        return binarySearchIterate(nums, target);
    }

    //    递归
    public static int binarySearchRecursion(int[] nums, int left, int right, int target) {
        if (left > right) {
            return -1;
        }
        int mid = left + (right - left) / 2; //防止整数过大溢出
        if (target > nums[mid]) {
            return binarySearchRecursion(nums, mid + 1, right, target);
        } else if (target < nums[mid]) {
            return binarySearchRecursion(nums, left, mid - 1, target);
        } else {
            return mid;
        }
    }

    //    迭代
    public static int binarySearchIterate(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) { //mid小于target----改变左边界
                left = mid + 1;
            } else if (nums[mid] > target) { //mid大于target----改变右边界
                right = mid - 1;
            }
        }
        return -1;
    }
}
