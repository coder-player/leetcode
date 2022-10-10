package com.fqh.lc;

/**
 * @author The End of Death
 * @version 1.0
 * @since 2022/9/22 13:02:39
 */
public class LC_2414 {

    public static void main(String[] args) {

        String s = "awy";
        System.out.println(new LC_2414().longestContinuousSubstring(s));
    }

    public int longestContinuousSubstring(String s) {
        int res = 0;
        int len = s.length();
        for (int i = 1, j = 0; i < len; i++) {
            if ((int) s.charAt(i) - (int) s.charAt(i - 1) == 1) {
                res = Math.max(res, i - j + 1);
            } else {
                j = i;
            }
        }
        return res == 0 ? 1 : res;

    }
}
