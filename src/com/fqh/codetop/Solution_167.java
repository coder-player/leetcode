package com.fqh.codetop;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 我劝你荔枝_FQH
 * @version 1.0
 * Date: 2022/6/8 22:52:53
 * 167. 两数之和 II - 输入有序数组
 * 给你一个下标从 1 开始的整数数组 numbers ，该数组已按 非递减顺序排列  ，请你从数组中找出满足相加之和等于目标数 target 的两个数。如果设这两个数分别是 numbers[index1] 和 numbers[index2] ，则 1 <= index1 < index2 <= numbers.length 。
 * <p>
 * 以长度为 2 的整数数组 [index1, index2] 的形式返回这两个整数的下标 index1 和 index2。
 * <p>
 * 你可以假设每个输入 只对应唯一的答案 ，而且你 不可以 重复使用相同的元素。
 * <p>
 * 你所设计的解决方案必须只使用常量级的额外空间。
 * 示例 1：
 * <p>
 * 输入：numbers = [2,7,11,15], target = 9
 * 输出：[1,2]
 * 解释：2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。返回 [1, 2] 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/two-sum-ii-input-array-is-sorted
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_167 {

    public static void main(String[] args) {

        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        int[] twoSum = twoSum(numbers, target);
        System.out.println(Arrays.toString(twoSum));
    }

    //采用map O(n)空间
    public static int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int val = target - numbers[i];
            if (map.containsKey(val)) {
                return new int[]{map.get(val) + 1, i + 1};
            }
            map.put(numbers[i], i);
        }
        return new int[]{-1, -1};
    }
}
