package com.fqh.hot;

/**
 * @author 我劝你荔枝_FQH
 * @version 1.0
 * Date: 2022/6/19 18:33:29
 * 287. 寻找重复数
 * 给定一个包含 n + 1 个整数的数组 nums ，其数字都在 [1, n] 范围内（包括 1 和 n），可知至少存在一个重复的整数。
 * <p>
 * 假设 nums 只有 一个重复的整数 ，返回 这个重复的数 。
 * <p>
 * 你设计的解决方案必须 不修改 数组 nums 且只用常量级 O(1) 的额外空间。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/find-the-duplicate-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 输入：nums = [1,3,4,2,2]
 * 输出：2
 */
public class Solution_287 {

    public static void main(String[] args) {

        int[] nums = {3, 1, 3, 4, 2};
        System.out.println(findDuplicate(nums));
    }

    //TODO 超时了...
    public static int findDuplicate(int[] nums) {
        int fast = 1;
        int slow = 0;
        int target = 0;
        while (slow < nums.length) {
            if (fast == nums.length) {
                slow++;
                fast = slow + 1;
            }
            if (nums[fast] == nums[slow]) {
                target = nums[fast];
                break;
            } else {
                fast++;
            }
        }
        return target;
    }
}
