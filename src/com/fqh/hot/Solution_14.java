package com.fqh.hot;

/**
 * @author 我劝你荔枝
 * @version 1.0
 * Date: 2022/4/28 22:02:19
 * 14. 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 */
public class Solution_14 {

    public static void main(String[] args) {

        String[] strs = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        //公共前缀比所以字符串都短，随便选取一个
        String s = strs[0];
        ;
        for (int i = 1; i < strs.length; i++) {
            //如果当前字符串不是以我们选取的s开头【我们就让s变短】
            while (!strs[i].startsWith(s)) {
                if (s.length() == 0) {
                    return "";
                }
                s = s.substring(0, s.length() - 1);
            }
        }
        return s;
    }
}
