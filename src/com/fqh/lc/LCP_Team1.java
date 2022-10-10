package com.fqh.lc;


import java.util.HashSet;

/**
 * @author The End of Death
 * @version 1.0
 * @since 2022/10/7 15:41:09
 */
public class LCP_Team1 {

    public static void main(String[] args) {

        String[] demand = {"ccluro","mmjhp","ln","ayoqwqtqrh","m","luhnsb","gyyy","auuksw"};
        System.out.println(new LCP_Team1().minNumBooths(demand));
    }

    //N-AC
    public int minNumBooths(String[] demand) {
       int ans = 0;
       int[] hash = new int[26];
       int len = 0;
       int idx = 0;
       for (int i = 0; i < demand.length; i++) {
           if (len < demand[i].length()) {
               len = demand[i].length();
               idx = i;
           }
       }
       for (char c : demand[idx].toCharArray()) {
           hash[c - 'a']++;
       }
       for (int k = 0; k < demand.length; k++) {
           if (idx == k) continue;
           int[] map = new int[26];
           for (int i = 0; i < demand[k].length(); i++) {
               int ch = demand[k].charAt(i) - 'a';
               map[ch]++;
           }
           HashSet<Character> set = new HashSet<>();
           for (char c : demand[k].toCharArray()) set.add(c);
           for (char c : set) {
               int ch = c - 'a';
               if (hash[ch] == 0) {
                   ans += map[ch];
               } else {
                   ans += Math.max(hash[ch], map[ch]);
               }
           }
       }
       return ans;
    }
}
