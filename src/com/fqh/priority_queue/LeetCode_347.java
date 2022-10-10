package com.fqh.priority_queue;

/**
 * @author The End of Death
 * @version 1.0
 * @since 2022/9/23 13:24:43
 */

import com.fqh.tree.LeetCode_513;

import java.util.*;

/**
 * 347. 前 K 个高频元素
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 * 示例 1:
 * <p>
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * k 的取值范围是 [1, 数组中不相同的元素的个数]
 * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的
 * <p>
 * <p>
 * <p>
 * 进阶：你所设计算法的时间复杂度 必须 优于 O(n log n) ，其中 n 是数组大小。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/top-k-frequent-elements
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_347 {

    public static void main(String[] args) {

        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        int[] topKFrequent = new LeetCode_347().topKFrequent(nums, k);
        System.out.println(Arrays.toString(topKFrequent));
    }

    //优先队列
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Queue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(((o1, o2) -> o1.getValue() - o2.getValue()));
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.offer(entry);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        int[] res = new int[pq.size()];
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = pq.poll().getKey();
        }
        return res;
    }
}
