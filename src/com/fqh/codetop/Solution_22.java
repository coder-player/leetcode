package com.fqh.codetop;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 海盗狗
 * @version 1.0
 * 22.括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 */
public class Solution_22 {

    static List<String> res = new ArrayList<>();

    public static void main(String[] args) {

        int n = 3;
        System.out.println((generateParenthesis(n)));
    }

    public static List<String> generateParenthesis(int n) {
        StringBuilder path = new StringBuilder();
        backtrack(n, n, path);
        return res;
    }

    //    回溯模板
    public static void backtrack(int left, int right, StringBuilder path) {
        if (left < 0 || right < 0) { //左括号或右括号数量小于0了
            return;
        }
        if (left > right) { //左括号比右括号多直接返回
            return;
        }
        if (left == 0 && right == 0) { //左右括号都用光了
            res.add(path.toString()); //是一个合法的括号组合
            return;
        }
        path.append("("); //尝试添加一个左括号
        backtrack(left - 1, right, path); //左括号数量-1
        path.deleteCharAt(path.length() - 1); //撤销选择

        path.append(")"); //尝试添加一个右括号
        backtrack(left, right - 1, path); //右括号数量-1
        path.deleteCharAt(path.length() - 1); //撤销选择
    }
}
