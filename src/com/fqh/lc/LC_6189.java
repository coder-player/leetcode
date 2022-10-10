package com.fqh.lc;

/**
 * @author The End of Death
 * @version 1.0
 * @since 2022/9/25 11:00:24
 */
public class LC_6189 {

    public static void main(String[] args) {
//    System.out.println(1 & 2);
//    System.out.println(2 & 1);
        int[] nums = {1, 2, 3, 4};
        System.out.println(new LC_6189().longestSubarray(nums));
    }

    //N-AC
    public int longestSubarray(int[] nums) {
        int max = 1, result = 0, curr = 0;
        for (int num : nums) {
            if (num == max) {
                result = Math.max(result, ++curr);
            } else if (num > max) {
                max = num;
                result = curr = 1;
            } else {
                curr = 0;
            }
        }
        return result;
    }
}
