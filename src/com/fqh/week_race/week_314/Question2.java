package com.fqh.week_race.week_314;

/**
 * @author The End of Death
 * @version 1.0
 * @since 2022/10/10 15:48:26
 */

/**
 * 2.找出前缀异或的原始数组
 */
public class Question2 {

    public static void main(String[] args) {

    }

    public int[] findArray(int[] pref) {
        int n = pref.length;
        int[] ans = new int[n];
        ans[0] = pref[0];
        for (int i = 1; i < n; i++) {
            ans[i] = pref[i] ^ pref[i - 1];
        }
        return ans;
    }
}
