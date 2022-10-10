package com.fqh.codetop;

/**
 * @author 我劝你荔枝_FQH
 * @version 1.0
 * Date: 2022/6/11 23:03:20
 * 28. 实现 strStr()
 * 实现 strStr() 函数。
 * <p>
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回  -1 。
 * <p>
 * 说明：
 * <p>
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * <p>
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与 C 语言的 strstr() 以及 Java 的 indexOf() 定义相符。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/implement-strstr
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 输入：haystack = "hello", needle = "ll"
 * 输出：2
 */
public class Solution_28 {

    public static void main(String[] args) {

        String haystack = "hello";
        String needle = "ll";
        System.out.println(strStr(haystack, needle));
    }

    //kmp算法
    public static int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        int[] next = kmpNext(needle);
        int j = 0;
        for (int i = 0; i < haystack.length(); i++) {
            //返回上一次最长公共前后缀的位置
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = next[j - 1];
            }
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }
            //匹配成功
            if (j == needle.length()) {
                return i - j + 1;
            }
        }
        return -1;
    }

    //构建next数
    public static int[] kmpNext(String pattern) {
        int length = pattern.length();
        int[] next = new int[length];
        int j = 0;
        next[j] = 0;
        for (int i = 1; i < length; i++) {
            while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
                j = next[j - 1];
            }
            if (pattern.charAt(i) == pattern.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }
}
