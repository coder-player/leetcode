package com.fqh.codetop;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author 我劝你荔枝_FQH
 * @version 1.0
 * Date: 2022/6/15 13:13:32
 * 15. 三数之和
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 */
public class Solution_15 {

    public static void main(String[] args) {

        int[] nums = {-1, 0, 1, 2, -1, -4};

        List<List<Integer>> list = threeSum(nums);
        System.out.println(list);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> set = three(nums, 0);
        return new ArrayList<>(set);
    }

    //TODO 双指针 + set去重【效率较低】
    public static Set<List<Integer>> three(int[] nums, int target) {
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int val = target - nums[i];
            for (int j = i + 1, k = nums.length - 1; j < nums.length; j++) {
                while (j < k && (nums[j] + nums[k] > val)) {
                    k--;
                }
                if (j == k) {
                    break;
                }
                if (nums[j] + nums[k] == val) {
                    List<Integer> list = Arrays.asList(nums[i], nums[j], nums[k]);
                    set.add(list);
                }
            }
        }
        return set;
    }
}
