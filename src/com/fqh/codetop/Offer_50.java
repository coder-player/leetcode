package com.fqh.codetop;

/**
 * @author 我劝你荔枝_FQH
 * @version 1.0
 * Date: 2022/6/23 23:29:24
 */
public class Offer_50 {

    public static void main(String[] args) {

        String s = "leetcode";
        System.out.println(firstUniqChar(s));
    }

    public static char firstUniqChar(String s) {
        int[] hash = new int[123];
        for (char ch : s.toCharArray()) {
            if (hash[ch] >= 1) {
                hash[ch] += 1;
            } else {
                hash[ch] = 1;
            }
        }
        for (char ch : s.toCharArray()) {
            if (hash[ch] == 1) {
                return ch;
            }
        }
        return ' ';
    }
}
