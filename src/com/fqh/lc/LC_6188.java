package com.fqh.lc;


import java.util.*;

/**
 * @author The End of Death
 * @version 1.0
 * @since 2022/9/25 10:33:38
 */
public class LC_6188 {

    public static void main(String[] args) {

        String[] names = {"Alice", "Bob", "Bob"};
        int[] heights = {155, 185, 150};
        System.out.println(Arrays.toString(new LC_6188().sortPeople(names, heights)));
    }

    //AC
    public String[] sortPeople(String[] names, int[] heights) {
        HashMap<Integer, String> map = new HashMap<>();
        Queue<Map.Entry<Integer, String>> pq = new PriorityQueue<>(((o1, o2) -> o2.getKey() - o1.getKey()));
        for (int i = 0; i < names.length; i++) {
            map.put(heights[i], names[i]);
        }
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            pq.offer(entry);
        }
        for (int i = 0; i < names.length; i++) {
            names[i] = pq.poll().getValue();
        }
        return names;
    }
}
