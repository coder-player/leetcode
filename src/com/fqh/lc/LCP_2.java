package com.fqh.lc;

import java.util.*;

/**
 * @author The End of Death
 * @version 1.0
 * @since 2022/9/24 15:21:04
 */
public class LCP_2 {

    public static void main(String[] args) {

        int[][] path = {
                {2, 5},
                {4, 3},
                {2, 3}
        };
        int[][] paths = {{30, 6}, {23, 6}, {22, 6}, {31, 6}, {39, 6}, {27, 6}, {3, 6}, {26, 6}, {9, 40}, {37, 6}, {29, 6}, {7, 4}, {25, 6}, {24, 6}, {40, 2}, {5, 6}, {19, 6}, {17, 6}, {21, 6}, {30, 15}, {15, 6}, {13, 6}, {33, 6}, {10, 6}, {11, 6}, {9, 6}, {28, 6}, {35, 6}, {4, 6}, {20, 6}, {33, 13}, {36, 6}, {7, 6}, {34, 6}, {14, 6}, {8, 6}, {18, 6}, {12, 6}, {1, 6}, {32, 6}, {9, 0}, {38, 6}, {16, 6}, {2, 6}, {0, 6}};

        System.out.println(new LCP_2().transportationHub(path));
    }

    Set<Integer> set = new HashSet<>();

    //AC
    public int transportationHub(int[][] path) {
        List<Integer>[] table = build(path);
        HashMap<Integer, Integer> map = new HashMap<>();
        Set<Integer> pointSet = new HashSet<>();
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null && table[i].size() > 0) {
                for (int n : table[i]) {
                    map.put(n, map.getOrDefault(n, 0) + 1);
                }
                pointSet.add(i);
            }
        }
        int target = -1;
        int maxTimes = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            if (maxTimes < value) {
                maxTimes = value;
                target = key;
            }
        }
        if (table[target].size() == 0) {
            if (!pointSet.contains(target) && maxTimes == set.size() - 1) {
                return target;
            }
        }
        return -1;
    }

    public List<Integer>[] build(int[][] path) {
        List<Integer>[] table = new List[1000];
        for (int i = 0; i < 1000; i++) {
            table[i] = new LinkedList<>();
        }
        for (int[] link : path) {
            int from = link[0];
            int to = link[1];
            set.add(from);
            set.add(to);
            table[from].add(to);
        }
        return table;
    }

}
