package com.fqh.hot;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 海盗狗
 * @version 1.0
 * 1. 两数之和
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 */
public class Solution_1 {

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] ints = twoSum(nums, target);

        System.out.println(Arrays.toString(ints));
    }

    public static int[] twoSum(int[] nums, int target) {
//        构建哈希表存储val
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int val = target - nums[i];
//            如果map包含val, 返回 val 对应的索引 和 i
            if (map.containsKey(val)) {
                return new int[]{map.get(val), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
}
