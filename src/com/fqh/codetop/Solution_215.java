package com.fqh.codetop;

/**
 * @author 海盗狗
 * @version 1.0
 * 215. 数组中的第K个最大元素
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 */
public class Solution_215 {

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        System.out.println(findKthLargest(nums, k));
    }

    public static int findKthLargest(int[] nums, int k) {
        quickSort(nums, 0, nums.length - 1);
        return nums[nums.length - k];
    }

    public static void quickSort(int[] nums, int left, int right) {
        int l = left;
        int r = right;
        int pivot = nums[left + (right - left) / 2]; //基准值
        int temp = 0;
        while (l < r) {
            while (nums[l] < pivot) {
                l += 1;
            }
            while (nums[r] > pivot) {
                r -= 1;
            }
            if (l >= r) {
                break;
            }
            temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            if (nums[l] == pivot) {
                r -= 1;
            }
            if (nums[r] == pivot) {
                l += 1;
            }
        }
        if (l == r) {
            l += 1;
            r -= 1;
        }
        if (l < right) {
            quickSort(nums, l, right);
        }
        if (r > left) {
            quickSort(nums, left, r);
        }
    }
}
