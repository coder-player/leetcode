package com.fqh.hot;

/**
 * @author The End of Death
 * @version 1.0
 * @since 2022/9/23 16:52:28
 */

import java.util.Stack;

/**
 * 32. 最长有效括号
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 * 输入：s = "(()"
 * 输出：2
 * 解释：最长有效括号子串是 "()"
 * 输入：s = ")()())"
 * 输出：4
 * 解释：最长有效括号子串是 "()()"
 */
public class Solution_32 {

    public static void main(String[] args) {

        String s = ")()())";
        System.out.println(new Solution_32().longestValidParentheses(s));
    }

    public int longestValidParentheses(String s) {
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                }
                // 维护最长有效括号
                ans = Math.max(i - stack.peek(), ans);
            }
        }
        return ans;
    }
}
