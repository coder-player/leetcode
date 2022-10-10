package com.fqh.codetop;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author 我劝你荔枝_FQH
 * @version 1.0
 * Date: 2022/6/1 23:05:41
 * 739. 每日温度
 * 给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指在第 i 天之后，才会有更高的温度。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/daily-temperatures
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 示例 1:
 * <p>
 * 输入: temperatures = [73,74,75,71,69,72,76,73]
 * 输出: [1,1,4,2,1,1,0,0]
 */
public class Solution_739 {

    public static void main(String[] args) {

        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] dailyTemperatures = dailyTemperatures(temperatures);
        System.out.println(Arrays.toString(dailyTemperatures));
    }

    //单调栈
    public static int[] dailyTemperatures(int[] temperatures) {
        LinkedList<Integer> stack = new LinkedList<>();
        int[] ans = new int[temperatures.length];
        for (int i = temperatures.length - 1; i >= 0; i--) {
            //把低的踢出去
            while (!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) {
                stack.pop();
            }
            ans[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i); //存储索引
        }
        return ans;
    }
}
