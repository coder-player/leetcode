package com.fqh.codetop;

/**
 * @author 海盗狗
 * @version 1.0
 * 136. 只出现一次的数字
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * <p>
 * 说明：
 * <p>
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/single-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 输入: [4,1,2,1,2]
 * 输出: 4
 */
public class Solution_136 {

    public static void main(String[] args) {

        int[] nums = {4, 1, 2, 1, 2};
        System.out.println(singleNumber(nums));
    }

    //异或运算
    //a ^ b = b ^ a, 0 ^ n = n, n ^ n = 0
    public static int singleNumber(int[] nums) {
        int num = nums[0];
        for (int i = 1; i < nums.length; i++) {
            num ^= nums[i];
        }
        return num;
    }
}
