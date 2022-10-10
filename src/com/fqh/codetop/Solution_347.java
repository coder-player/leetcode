package com.fqh.codetop;

import sun.nio.cs.ext.IBM037;

import java.util.*;

/**
 * @author 我劝你荔枝_FQH
 * @version 1.0
 * Date: 2022/4/30 23:18:42
 * 347. 前 K 个高频元素
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 进阶：你所设计算法的时间复杂度 必须 优于 O(n log n) ，其中 n 是数组大小。
 */
public class Solution_347 {

    public static void main(String[] args) {

        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        int[] kFrequent = topKFrequent(nums, k);
        System.out.println(Arrays.toString(kFrequent));
    }

    //map计数 + 优先队列
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>(); //统计各个元素出现的次数
        for (int item : nums) {
            map.put(item, map.getOrDefault(item, 0) + 1);
        }
        //使用优先队列【指定出现次数最小的排在前面---->满足k个的时候好出队列】
        Queue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
                (o1, o2) -> o1.getValue() - o2.getValue()
        );
        //将entry加入优先队列
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.offer(entry);
            if (pq.size() > k) { //总保证队列元素的个数 <= k【前k个】
                pq.poll();
            }
        }
        int[] res = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            res[i] = pq.poll().getKey();
        }
        return res;
    }
}
