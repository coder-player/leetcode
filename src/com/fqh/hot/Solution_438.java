package com.fqh.hot;

import java.util.*;

/**
 * @author 我劝你荔枝_FQH
 * @version 1.0
 * Date: 2022/6/19 21:18:12
 * 438. 找到字符串中所有字母异位词
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * <p>
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/find-all-anagrams-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 示例 1:
 * <p>
 * 输入: s = "cbaebabacd", p = "abc"
 * 输出: [0,6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 * <p>
 * "ababababab"
 * "aab"
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/find-all-anagrams-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_438 {

    public static void main(String[] args) {

        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> anagrams = findAnagrams(s, p);
        System.out.println(anagrams);
        System.out.println('z' + 0);

    }

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        int[] hash = new int[123];
        for (char c : p.toCharArray()) {
            if (hash[c] != 0) {
                hash[c] += 1;
            } else {
                hash[c] = 1;
            }
        }
        int fast = p.length() - 1;
        int slow = 0;
        boolean isWords;
        while (fast < s.length()) {
            isWords = true;

            for (int i = slow; i <= fast; i++) {
                if (hash[s.charAt(i)] == 0) {
                    isWords = false;
                    break;
                }
                hash[s.charAt(i)] -= 1;

            }
            if (isWords) {
                list.add(slow);
            }
            slow++;
            fast++;
        }
        return list;
    }
}
