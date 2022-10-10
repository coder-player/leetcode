package com.fqh.hot;

/**
 * @author 海盗狗
 * @version 1.0
 * 136. 只出现一次的数字
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * 输入: [4,1,2,1,2]
 * 输出: 4
 */
public class Solution_136 {

    public static void main(String[] args) {

        int[] nums = {4, 1, 2, 1, 2};
        int number = singleNumber(nums);

        System.out.println(number);
        System.out.println(Integer.parseInt("100", 2));

    }

    public static int singleNumber(int[] nums) {
//        相同的数异或为0 : n ^ n = 0
//        任何数异或0为任何数 : n ^ 0 = n
//        a ^ b ^ c = a ^ c ^ b
        int num = 0;
        for (int i = 0; i < nums.length; i++) {
            num = num ^ nums[i];
        }
        return num;
    }
}
