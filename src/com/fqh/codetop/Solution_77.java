package com.fqh.codetop;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 我劝你荔枝_FQH
 * @version 1.0
 * Date: 2022/5/5 23:54:35
 * 77. 组合
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * <p>
 * 你可以按 任何顺序 返回答案。
 * 输入：n = 4, k = 2
 * 输出：
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 */
public class Solution_77 {

    public static void main(String[] args) {

        int n = 4;
        int k = 2;
        System.out.println(combine(n, k));
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<Integer> list = new ArrayList<>();
        backtrack(1, n, k, list);
        return res;
    }

    static List<List<Integer>> res = new ArrayList<>();

    //回溯模板
    public static void backtrack(int start, int n, int k, List<Integer> list) {
        if (list.size() == k) { //找到一个组合
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i <= n; i++) {
            list.add(i); //选择一个
            backtrack(i + 1, n, k, list);
            list.remove(list.size() - 1); //撤销选择
        }
    }
}
