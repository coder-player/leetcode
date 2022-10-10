package com.fqh.codetop;

/**
 * @author 我劝你荔枝
 * @version 1.0
 * Date: 2022/4/26 23:18:56
 * 169. 多数元素
 * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/majority-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ========================================================
 * 进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。
 * 示例 2：
 * <p>
 * 输入：nums = [2,2,1,1,1,2,2]
 * 输出：2
 */
public class Solution_169 {

    public static void main(String[] args) {

        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        System.out.println(majorityElement(nums));
    }

    //摩尔投票法
    public static int majorityElement(int[] nums) {
        //选择候选人
        int candidate = nums[0];
        int count = 1; //记录候选人出现的次数
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) { //count被减为0
                candidate = nums[i]; //将当前元素选为候选人
            }
            //计数操作
            if (nums[i] == candidate) {
                count++;
            } else {
                count--;
            }
        }
        return candidate;
    }
}
