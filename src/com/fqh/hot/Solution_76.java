package com.fqh.hot;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 我劝你荔枝_FQH
 * @version 1.0
 * Date: 2022/7/7 22:08:11
 * 76. 最小覆盖子串
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * 示例 1：
 * <p>
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 */
public class Solution_76 {

    public static void main(String[] args) {

        Map<Character, Integer> map = new HashMap<>();
        map.put('A', 1);
        map.put('A', map.getOrDefault('A', 0) - 1);

        String s = "ADOBECODEBANC";
        String t = "ABC";

//        System.out.println(map);
        System.out.println(minWindow(s, t));
    }

    /**
     * TODO 难度===>困难 滑动窗口
     */
    public static String minWindow(String s, String t) {
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int l = 0;
        int r = 0;
        int valid = 0;
        int start = 0;
        int len = Integer.MAX_VALUE;
        while (r < s.length()) {
            char c = s.charAt(r);
            r++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }
            //缩小窗口
            while (valid == need.size()) {
                if (r - l < len) {
                    start = l;
                    len = r - l;
                }
                char d = s.charAt(l);
                l++;
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }
}
