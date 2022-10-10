package com.fqh.hot;

/**
 * @author The End of Death
 * @version 1.0
 * @since 2022/9/23 16:22:50
 */

/**
 * 11. 盛最多水的容器
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 * <p>
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 返回容器可以储存的最大水量。
 * <p>
 * 说明：你不能倾斜容器。
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/container-with-most-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/container-with-most-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_11 {

    public static void main(String[] args) {

        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(new Solution_11().maxArea(height));
    }

    //DP
    public int maxArea(int[] height) {
        int ans = 0;
        int i = 0;
        int j = height.length - 1;
        while (i < j) {
            // 求出当前能够盛最多水的面积
            int area = Math.min(height[i], height[j]) * (j - i);
            ans = Math.max(area, ans);
            // 容器宽度在不断缩小 ===> 需要维护容器的高度最高,移动高度低的指针
            if (height[i] < height[j]) {
                i += 1;
            } else {
                j -= 1;
            }
        }
        return ans;
    }
}
