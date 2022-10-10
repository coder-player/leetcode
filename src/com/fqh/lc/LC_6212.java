package com.fqh.lc;


import java.util.*;

/**
 * @author The End of Death
 * @version 1.0
 * @since 2022/10/1 23:16:00
 */
public class LC_6212 {

    public static void main(String[] args) {

//    String word = "abcc";
        String word = "abcc";
        System.out.println(new LC_6212().equalFrequency(word));
    }

    //N-AC TODO
    public boolean equalFrequency(String word) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : word.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            entry.setValue(entry.getValue() - 1);
        }
        int val = 0;
        boolean flag = true;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (flag) {
                val = entry.getValue();
                flag = false;
                continue;
            }
            if (entry.getValue() != val) {
                return false;
            }
            val = entry.getValue();
        }
        return true;
    }
}
