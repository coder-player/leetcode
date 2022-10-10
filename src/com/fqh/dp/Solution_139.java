package com.fqh.dp;

import java.util.Arrays;
import java.util.List;

/**
 * @author The End of Death
 * @version 1.0
 * @since 2022/10/6 13:01:00
 */
public class Solution_139 {

    public static void main(String[] args) {

        String s = "aaaaaaa";
        List<String> wordDict = Arrays.asList("aaaa", "aaa");
        System.out.println(new Solution_139().wordBreakByMemo(s, wordDict));
    }

    // 时间复杂度：O(n^2）
    // 空间复杂度：O(n)
    public boolean wordBreak(String s, List<String> wordDict) {
        // DP数组
        // ""   l     e     e     t    c     o     d      e
        // TRUE FLASE FALSE FALSE TRUE FALSE FALSE FALSE  TRUE
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length() + 1; j++) {
                if (dp[i] && wordDict.contains(s.substring(i, j))) {
                    dp[j] = true;
                }
            }
        }
        return dp[dp.length - 1];
    }

    // 记忆化回溯优化 避免重复计算
    public boolean wordBreakByMemo(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 0; i < s.length(); i++) {
            if (!dp[i]) {
                continue;
            }
            for (String word : wordDict) {
                if (word.length() + i <= s.length() && s.startsWith(word, i)) {
                    dp[i + word.length()] = true;
                }
            }
        }
        return dp[dp.length - 1];
    }
}
