package com.fqh.codetop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 海盗狗
 * @version 1.0
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
 */
public class Solution_34 {

    public static void main(String[] args) {

        int[] nums = {2, 2};
        int target = 2;
        int[] ints = searchRange(nums, target);
        System.out.println(Arrays.toString(ints));
    }

    public static int[] searchRange(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length - 1, target);
    }

    //    二分查找
    public static int[] binarySearch(int[] nums, int left, int right, int target) {
        if (left > right) {
            return new int[]{-1, -1};
        }
        int mid = left + (right - left) / 2;
        if (target < nums[mid]) {
            return binarySearch(nums, left, mid - 1, target);
        } else if (target > nums[mid]) {
            return binarySearch(nums, mid + 1, right, target);
        } else {
//            找到后先别直接返回, 左右扫描一遍
//            List<Integer> list = new ArrayList<>();
            int temp = mid;
            int leftBorder = temp; //左边界
            int rightBorder = temp; //右边界
            while (temp >= 0 && nums[temp] == target) {
                temp--;
            }
            leftBorder = temp + 1; //找到第一次出现的位置

            temp = mid; //重置temp位置开始向右扫描
            while (temp <= right && nums[temp] == target) {
                temp++;
            }
            rightBorder = temp - 1; //找到最后一次出现的位置
            return new int[]{leftBorder, rightBorder};
        }
    }
}
