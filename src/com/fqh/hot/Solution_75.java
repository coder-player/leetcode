package com.fqh.hot;

import java.util.Arrays;

/**
 * @author 海盗狗
 * @version 1.0
 * 75. 颜色分类
 * 给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * 必须在不使用库的sort函数的情况下解决这个问题。
 * 输入：nums = [2,0,2,1,1,0]
 * 输出：[0,0,1,1,2,2]
 */
public class Solution_75 {

    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        sortColors(nums);
    }

    public static void sortColors(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    //    快排
    public static void quickSort(int[] nums, int left, int right) {
        int l = left;
        int r = right;
//        中间值
        int pivot = nums[left + (right - left) / 2];
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
        if (r > left) {
            quickSort(nums, left, r);
        }
        if (l < right) {
            quickSort(nums, l, right);
        }

    }
}
