package com.fqh.hot;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 海盗狗
 * @version 1.0
 * 22. 括号生成
 */
public class Solution_22 {

    public static void main(String[] args) {

        int n = 3;
        System.out.println(generateParenthesis(n));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        backtrack(n, n, res, sb);

        return res;
    }


    public static void backtrack(int left, int right, List<String> res, StringBuilder sb) {
//        左括号 或 右括号 剩余数量 < 0, 不合法
        if (left < 0 || right < 0) {
            return;
        }
//        左括号剩下的多, 不合法
        if (right < left) {
            return;
        }
//        左右括号都恰好用完, 得到一个合法的括号组合
        if (left == 0 && right == 0) {
            res.add(sb.toString());
            return;
        }
//        尝试添加一个左括号
        sb.append("("); // 选择
        backtrack(left - 1, right, res, sb);
        sb.deleteCharAt(sb.length() - 1); // 撤销选择
//        尝试添加一个右括号
        sb.append(")");
        backtrack(left, right - 1, res, sb);
        sb.deleteCharAt(sb.length() - 1);
    }
}
