package com.fqh.hot;

import java.util.*;

/**
 * @author 海盗狗
 * @version 1.0
 * 49. 字母异位词分组
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 */
public class Solution_49 {
    public static void main(String[] args) {

        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};

        List<List<String>> lists = groupAnagrams(strs);
        System.out.println(lists);
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
//            将字符数组排好序
            Arrays.sort(chars);
//            转回排好序的字符串
            String key = String.valueOf(chars);
//            如果是字母异位词分组则key相同
            if (map.containsKey(key)) {
                map.get(key).add(str);
                continue;
            }
            map.put(key, new ArrayList<>());
            map.get(key).add(str); // 将当前字符串添加进去
        }
        return new ArrayList<>(map.values());
    }
}
