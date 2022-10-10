package com.fqh.codetop;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 我劝你荔枝_FQH
 * @version 1.0
 * Date: 2022/6/15 13:31:14
 * 3. 无重复字符的最长子串
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */
public class Solution_3 {

    public static void main(String[] args) {

        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }

    //滑动窗口
    public static int lengthOfLongestSubstring(String s) {
        int res = 0;
        int l = 0; //左边界索引
        int r = 0; //右边界索引

        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();

        while (r < chars.length) {
            if (map.containsKey(chars[r])) { //如果map中有这个字符
                map.remove(chars[l]); //从map中删除左边界字符
                l++;    //将左边界索引移动, 缩小窗口
            } else {
                map.put(chars[r], 0); //右边界不断扩大
                r++;
            }
            res = Math.max(res, r - l); //维护最长的无重复子串
        }
        return res;
    }
}
