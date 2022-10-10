package com.fqh.sort;

import java.util.Arrays;

/**
 * @author 我劝你荔枝_FQH
 * @version 1.0
 * Date: 2022/6/12 22:58:57
 * 归并排序
 */
public class MergeSortDemo {

    public static void main(String[] args) {

        int[] nums = {5, 8, 6, 3, 9, 2, 1, 7};
        mergeSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
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

