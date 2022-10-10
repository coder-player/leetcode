package com.fqh.hot;


/**
 * @author 我劝你荔枝_FQH
 * @version 1.0
 * Date: 2022/7/12 23:01:47
 * 42. 接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/trapping-rain-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_42 {

    public static void main(String[] args) {

        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(height));
    }

    //TODO 难度===>困难
    public static int trap(int[] height) {
        int i;
        int max = 0;
        int maxIdx = 0;
        //找到最长的柱子的索引
        for (i = 0; i < height.length; i++) {
            if (height[i] > max) {
                max = height[i];
                maxIdx = i;
            }
        }
        int area = 0;
        int temp = height[0];
        //从起点向maxIdx扫描
        for (i = 0; i < maxIdx; i++) {
            if (temp > height[i]) {
                //可以接到雨水
                area += temp - height[i];
            } else {
                temp = height[i];
            }
        }
        //从终点向maxIdx扫描
        temp = height[height.length - 1];
        for (int j = height.length - 1; j > maxIdx; j--) {
            if (temp > height[j]) {
                //可以接到雨水
                area += temp - height[j];
            } else {
                temp = height[j];
            }
        }
        return area;
    }

}
