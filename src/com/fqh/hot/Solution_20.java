package com.fqh.hot;

import java.util.Stack;

/**
 * @author 海盗狗
 * @version 1.0
 * 20. 有效的括号
 * 输入：s = "()[]{}"
 * 输出：true
 */
public class Solution_20 {

    public static void main(String[] args) {

        String s = "(){}[]";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(c);
                continue;
            }
//            如果为右括号就弹出一个元素不匹配就返回false
            if (c == ')') {
                if (stack.pop() != '(') {
                    return false;
                }
            } else if (c == ']') {
                if (stack.pop() != '[') {
                    return false;
                }
            } else if (c == '}') {
                if (stack.pop() != '{') {
                    return false;
                }
            } else {
//                左括号直接入栈
                stack.push(c);
            }
        }
//        返回是否全部匹配
        return stack.isEmpty();
    }
}
