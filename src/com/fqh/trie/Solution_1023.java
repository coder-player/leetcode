package com.fqh.trie;

import java.util.ArrayList;
import java.util.List;

/**
 * @author The End of Death
 * @version 1.0
 * @since 2022/10/7 19:00:25
 */
public class Solution_1023 {

    public static void main(String[] args) {

        String[] queries = {"FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"};
        String pattern = "FB";
        System.out.println(new Solution_1023().camelMatch(queries, pattern));
    }

    //TODO
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        TrieNode root = new TrieNode();
        TrieNode cur = root;
        for (char c : pattern.toCharArray()) {
            if (c >= 65 && c <= 90) {
                if (cur.next[c] == null) {
                    cur.next[c] = new TrieNode();
                }
                cur = cur.next[c];
            }

        }
        cur.isEnd = true;
        List<Boolean> res = new ArrayList<>();
        for (String str : queries) {
            List<Character> list = new ArrayList<>();
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) >= 65 && str.charAt(i) <= 90) {
                    list.add(str.charAt(i));
                }
            }
            res.add(match(root, list));
        }
        return res;
    }

    public boolean match(TrieNode root, List<Character> list) {
        TrieNode cur = root;
        for (char c : list) {
            if (cur.next[c] == null) {
                return false;
            }
            cur = cur.next[c];
        }
        return cur.isEnd;
    }

    static class TrieNode {
        TrieNode[] next;
        boolean isEnd;

        public TrieNode() {
            this.next = new TrieNode[124];
            this.isEnd = false;
        }
    }
}
