package com.fqh.hot;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author 我劝你荔枝_FQH
 * @version 1.0
 * Date: 2022/6/23 23:01:35
 * 139. 单词拆分
 * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。
 * <p>
 * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/word-break
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 示例 1：
 * <p>
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/word-break
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_139 {

    public static void main(String[] args) {

        String s = "leetcode";
        List<String> wordDict = Arrays.asList("leet", "code");
        System.out.println(wordBreak(s, wordDict));
    }

    //TODO
    public static boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> words = new HashSet<>(wordDict);
        boolean[] flags = new boolean[s.length() + 1];
        flags[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (flags[j] && words.contains(s.substring(j, i))) {
                    flags[i] = true;
                    break;
                }
            }
        }
        return flags[s.length()];
    }
}
