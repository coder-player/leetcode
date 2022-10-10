package com.fqh.codetop;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author 我劝你荔枝_FQH
 * @version 1.0
 * Date: 2022/6/14 23:00:46
 * 75. 颜色分类
 * 给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * <p>
 * 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * <p>
 * 必须在不使用库的sort函数的情况下解决这个问题。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/sort-colors
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 输入：nums = [2,0,2,1,1,0]
 * 输出：[0,0,1,1,2,2]
 */
public class Solution_75 {

    public static void main(String[] args) {

        int[] nums = {2, 0, 2, 1, 1, 0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    //归并排序
    public static void sortColors(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
    }

    //归并排序
    public static void mergeSort(int[] nums, int start, int end) {
        if (start < end) {
            //数组折半小集合, 分别进行递归
            int mid = (start + end) / 2;
            mergeSort(nums, start, mid);
            mergeSort(nums, mid + 1, end);
            //把两个小集合, 合并成一个大集合
            merge(nums, start, mid, end);
        }
    }

    //合并
    private static void merge(int[] nums, int start, int mid, int end) {
        //开辟额外大集合, 设置指针
        int[] temp = new int[end - start + 1];
        int p1 = start;
        int p2 = mid + 1;
        int p = 0;
        //1.比较两个小集合的元素, 依次放入大集合
        while ((p1 <= mid) && (p2 <= end)) {
            if (nums[p1] <= nums[p2]) {
                temp[p++] = nums[p1++];
            } else {
                temp[p++] = nums[p2++];
            }
        }
        //2.左侧小集合还有剩余元素, 依次放入大集合
        while (p1 <= mid) {
            temp[p++] = nums[p1++];
        }
        //3.右侧小集合还有剩余元素, 依次放入大集合
        while (p2 <= end) {
            temp[p++] = nums[p2++];
        }
        //4.把大集合的元素复制回原来的数组
        for (int i = 0; i < temp.length; i++) {
            nums[i + start] = temp[i];
        }
    }
}
