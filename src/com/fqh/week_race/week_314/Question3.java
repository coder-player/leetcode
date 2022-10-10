package com.fqh.week_race.week_314;

/**
 * @author The End of Death
 * @version 1.0
 * @since 2022/10/10 15:54:09
 */

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 3.使用机器人打印字典序最小的字符串
 */
public class Question3 {

    public static void main(String[] args) {

        String s = "zza";
        System.out.println(new Question3().robotWithString(s));
    }

    public String robotWithString(String s) {
        StringBuilder ans = new StringBuilder();
        char[] chars = s.toCharArray();
        int[] cnt = new int[26];
        for (char c : chars) ++cnt[c - 'a'];
        int min = 0; // 剩余最小字母
        Deque<Character> st = new ArrayDeque<Character>();
        for (char c : chars) {
            --cnt[c - 'a'];
            while (min < 25 && cnt[min] == 0) ++min; // 2
            st.push(c); // a z z
            while (!st.isEmpty() && st.peek() - 'a' <= min)
                ans.append(st.poll());
        }
        return ans.toString(); // a
    }
}
