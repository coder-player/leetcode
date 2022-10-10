package com.fqh.codetop;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author 我劝你荔枝_FQH
 * @version 1.0
 * Date: 2022/5/2 22:59:30
 * 150. 逆波兰表达式求值
 * 根据 逆波兰表示法，求表达式的值。
 * <p>
 * 有效的算符包括 +、-、*、/ 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 * <p>
 * 注意 两个整数之间的除法只保留整数部分。
 * <p>
 * 可以保证给定的逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/evaluate-reverse-polish-notation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 输入：tokens = ["2","1","+","3","*"]
 * 输出：9
 * 解释：该算式转化为常见的中缀算术表达式为：((2 + 1) * 3) = 9
 */
public class Solution_150 {

    public static void main(String[] args) {

        String[] tokens = {"2", "1", "+", "3", "*"};
        System.out.println(evalRPN(tokens));
    }

    //利用栈的特性
    public static int evalRPN(String[] tokens) {
        int num1 = 0;
        int num2 = 0;
        LinkedList<Integer> stack = new LinkedList<>(); //不用Stack类【底层是Vector】
        for (String s : tokens) {
            if (s.equals("+")) { //如果是+号---弹出两个元素进行运行再push进栈
                num1 = stack.removeLast();
                num2 = stack.removeLast();
                stack.addLast(num1 + num2);
            } else if (s.equals("-")) { //如果是-号---弹出两个元素进行运行再push进栈
                num1 = stack.removeLast();
                num2 = stack.removeLast();
                stack.addLast(num2 - num1);
            } else if (s.equals("*")) {
                num1 = stack.removeLast();
                num2 = stack.removeLast();
                stack.addLast(num1 * num2);
            } else if (s.equals("/")) {
                num1 = stack.removeLast();
                num2 = stack.removeLast();
                stack.addLast(num2 / num1);
            } else { //数字直接入栈
                stack.addLast(Integer.parseInt(s));
            }
        }
        return stack.getLast();
    }
}
