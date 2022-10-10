package com.fqh.codetop;

import java.util.Stack;

/**
 * @author 海盗狗
 * @version 1.0
 * 20.有效的括号
 * 输入：s = "()[]{}"
 * 输出：true
 */
public class Solution_20 {

    public static void main(String[] args) {
        String s = "()[]{}";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (stack.isEmpty()) {
                stack.push(c);
                continue;
            }
            if (c == ')') {
                if ('(' != stack.pop()) {
                    return false;
                }
            } else if (c == ']') {
                if ('[' != stack.pop()) {
                    return false;
                }
            } else if (c == '}') {
                if ('{' != stack.pop()) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
