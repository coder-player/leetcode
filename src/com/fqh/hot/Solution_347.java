package com.fqh.hot;

import java.util.*;

/**
 * @author 海盗狗
 * @version 1.0
 * 347. 前 K 个高频元素
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 */
public class Solution_347 {

    public static void main(String[] args) {

        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        int[] res = topKFrequent(nums, k);
        System.out.println(Arrays.toString(res));
    }

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[k];
//        统计元素出现次数
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
//        优先队列, 小的排前面
        Queue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((o1, o2) -> o1.getValue() - o2.getValue());

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.offer(entry);
//            队列的size > k 就poll, 指定先弹出出现次数小的元素
            if (pq.size() > k) {
                pq.poll();
            }
        }
        for (int i = k - 1; i >= 0; i--) {
            result[i] = pq.poll().getKey();
        }
        return result;
    }
}
