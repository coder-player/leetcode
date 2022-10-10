package com.fqh.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 我劝你荔枝_FQH
 * @version 1.0
 * Date: 2022/7/8 23:35:09
 * 438. 找到字符串中所有字母异位词
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * <p>
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 * 示例 1:
 * <p>
 * 输入: s = "cbaebabacd", p = "abc"
 * 输出: [0,6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/find-all-anagrams-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_438 {

    public static void main(String[] args) {

        String s = "abab";
        String p = "ab";
        List<Integer> anagrams = findAnagrams(s, p);
        System.out.println(anagrams);
    }

    //滑动窗口

    /**
     * *************
     * TODO
     * 执行用时：29 ms, 在所有 Java 提交中击败了24.34% 的用户
     * 内存消耗：42.8 MB, 在所有 Java 提交中击败了14.57% 的用户
     * ********************
     */
    public static List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (char c : p.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int l = 0, r = 0;
        int valid = 0;
        while (r < s.length()) {
            char c = s.charAt(r);
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }
            //这里保持窗口内只有p.length个字符
            if (r - l >= p.length()) {
                char c1 = s.charAt(l);
                if (need.containsKey(c1)) {
                    if (need.get(c1).equals(window.get(c1))) {
                        valid--;
                    }
                    window.put(c1, window.get(c1) - 1);
                }
                l++;
            }
            r++;
            //缩小窗口
            while (valid == need.size()) {
                char d = s.charAt(l);
                list.add(l);
                l++;
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        return list;
    }
}
