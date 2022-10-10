package com.fqh.codetop;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 我劝你荔枝_FQH
 * @version 1.0
 * Date: 2022/5/1 14:17:27
 * 剑指 Offer 53 - I. 在排序数组中查找数字 I
 * 统计一个数字在排序数组中出现的次数。
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 */
public class Offer_53_I {

    public static void main(String[] args) {

        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        System.out.println(search(nums, target));
    }

    public static int search(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length - 1, target);
    }

    //二分查找
    public static int binarySearch(int[] nums, int left, int right, int target) {
        if (left > right) {
            return 0;
        }
        int mid = left + (right - left) / 2;
        if (target > nums[mid]) { //向右搜索
            return binarySearch(nums, mid + 1, right, target);
        } else if (target < nums[mid]) { //向左搜索
            return binarySearch(nums, left, mid - 1, target);
        } else {
            int count = 1; //初始化1次
            int temp = mid - 1; //开始向左向右扫描【看看有没有跟target值相等的元素】
            while (temp >= 0 && nums[temp] == target) {
                count++;
                temp--;
            }
            temp = mid + 1; //重置temp的值
            while (temp <= right && nums[temp] == target) {
                count++;
                temp++;
            }
            return count;
        }
    }
}
