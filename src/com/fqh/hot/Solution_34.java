package com.fqh.hot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 海盗狗
 * @version 1.0
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 */
public class Solution_34 {

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        int[] ans = searchRange(nums, target);

        System.out.println(Arrays.toString(ans));
    }

    public static int[] searchRange(int[] nums, int target) {
        return binarySearch(0, nums.length - 1, nums, target);
    }

    public static int[] binarySearch(int left, int right, int[] nums, int target) {
//        二分边界判断
        if (left > right) {
            return new int[]{-1, -1};
        }
//        防止整数溢出
        int mid = left + (right - left);
//        向右搜索
        if (target > nums[mid]) {
            return binarySearch(mid + 1, right, nums, target);
        } else if (target < nums[mid]) {
//            向左搜索
            return binarySearch(left, mid - 1, nums, target);
        } else {
//            搜到后不立即返回, 以当前位置为中心向左右搜索
            int temp = mid - 1;
            List<Integer> list = new ArrayList<>();
//            左搜索
            while (temp >= 0 && nums[temp] == target) {
                list.add(temp--);
            }
            list.add(mid);
            temp = mid + 1;
//            右搜索
            while (temp <= right && nums[temp] == target) {
                list.add(temp++);
            }
            int[] ans = new int[list.size()];
            for (int i = 0; i < ans.length; i++) {
                ans[i] = list.get(i);
            }
            return ans;
        }
    }
}
