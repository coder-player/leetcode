package com.fqh.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 我劝你荔枝_FQH
 * @version 1.0
 * Date: 2022/7/9 22:17:25
 * 567. 字符串的排列
 * 给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。
 * <p>
 * 换句话说，s1 的排列之一是 s2 的 子串 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/permutation-in-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 示例 1：
 * <p>
 * 输入：s1 = "ab" s2 = "eidbaooo"
 * 输出：true
 * 解释：s2 包含 s1 的排列之一 ("ba").
 * "abcdxabcde"
 * "abcdeabcdx"
 */
public class Solution_567 {

    public static void main(String[] args) {

        String s1 = "abcdxabcde";
        String s2 = "abcdeabcdx";
        System.out.println(checkInclusion(s1, s2));
    }

    /**
     * ************
     * TODO
     * 执行用时：27 ms, 在所有 Java 提交中击败了18.47% 的用户
     * 内存消耗：41.2 MB, 在所有 Java 提交中击败了66.17% 的用户
     * *********************
     */
    //滑动窗口
    public static boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> target = new HashMap<>();
        for (char c : s1.toCharArray()) {
            target.put(c, target.getOrDefault(c, 0) + 1);
        }
        int l = 0, r = 0;
        int valid = 0;
        while (r < s2.length()) {
            char c = s2.charAt(r);
            if (target.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(target.get(c))) {
                    valid++;
                }
            }
            //缩小窗口
            if (r - l >= s1.length()) {
                char d = s2.charAt(l);
                if (target.containsKey(d)) {
                    if (window.get(d).equals(target.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
                l++;
            }
            r++;
            if (valid == target.size()) {
                return true;
            }

        }
        return false;
    }

}
