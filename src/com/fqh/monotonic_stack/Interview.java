package com.fqh.monotonic_stack;

/**
 * @author The End of Death
 * @version 1.0
 * @since 2022/9/23 19:05:50
 */

import java.util.Arrays;
import java.util.Stack;

/**
 * xx跳动<br>
 * 数组元素随机无序 要求打印出所有元素右边第一个大于该元素的值<br>
 * 示例:<br>
 * 给定数组: [2,6,3,8,10,9]<br>
 * 返回数组: [6,8,8,10,-1,-1]<br>
 */
public class Interview {

    public static void main(String[] args) {
        int[] nums = {2, 6, 3, 8, 10, 9};
        int[] ints = new Interview().nextGreaterElements(nums);
        System.out.println(Arrays.toString(ints));
    }


    //单调栈
    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i]) {
                stack.pop();
            }
            res[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i]);
        }
        return res;
    }

}
