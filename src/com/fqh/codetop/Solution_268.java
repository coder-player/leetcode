package com.fqh.codetop;

/**
 * @author 我劝你荔枝_FQH
 * @version 1.0
 * Date: 2022/6/7 23:31:58
 * 268. 丢失的数字
 * 给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。
 * 输入：nums = [3,0,1]
 * 输出：2
 * 解释：n = 3，因为有 3 个数字，所以所有的数字都在范围 [0,3] 内。2 是丢失的数字，因为它没有出现在 nums 中。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/missing-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_268 {

    public static void main(String[] args) {

        int[] nums = {3, 0, 1};
        System.out.println(missingNumber(nums));
    }

    //原地hash
    public static int missingNumber(int[] nums) {
        int len = nums.length;
        boolean[] hash = new boolean[len + 1]; //标记hash
        for (int i = 0; i < len; i++) {
            hash[nums[i]] = true; //作标记
        }
        for (int i = 0; i < len; i++) {
            if (!hash[i]) { //发现没有标记的数字就是缺失的数字
                return i;
            }
        }
        return len;
    }
}
