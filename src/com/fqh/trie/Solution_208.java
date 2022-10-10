package com.fqh.trie;

/**
 * @author The End of Death
 * @version 1.0
 * @since 2022/10/7 10:40:31
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 208. 实现 Trie (前缀树)
 */
public class Solution_208 {

    public static void main(String[] args) {

//        Trie trie = new Trie();
//        trie.insert("apple");
    }

    public int[] sumPrefixScores(String[] words) {
        int[] res = new int[words.length];
        TrieNode root = new TrieNode();
        for (int i = 0; i < words.length; i++) {
            TrieNode cur = root;
            String word = words[i];
            for (int j = 0; j < word.length(); j++) {
                int ch = word.charAt(j) - 'a';
                if (cur.son[ch] == null) {
                    cur.son[ch] = new TrieNode();
                }
                cur = cur.son[ch];
                cur.score += 1;
            }
            cur.ids.add(i);
        }
        return dfs(root, 0, res);
    }

    public int[] dfs(TrieNode node, int sum, int[] res) {
        if (node == null) return res;
        sum += node.score;
        for (Integer i : node.ids) {
            res[i] = sum;
        }
        for (TrieNode child : node.son) {
            dfs(child, sum, res);
        }
        return res;
    }


    static class Trie {

        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode cur = root;
            int ch;
            for (int i = 0; i < word.length(); i++) {
                ch = word.charAt(i) - 'a';
                if (cur.son[ch] == null) {
                    cur.son[ch] = new TrieNode();
                }
                cur = cur.son[ch];
            }
            cur.isEnd = true; // 标记为一个单词
        }

        public boolean search(String word) {
            TrieNode cur = root;
            int ch;
            for (int i = 0; i < word.length(); i++) {
                ch = word.charAt(i) - 'a';
                if (cur.son[ch] == null) {
                    return false;
                }
                cur = cur.son[ch];
            }
            return cur.isEnd;
        }

        public boolean startsWith(String prefix) {
            TrieNode cur = root;
            int ch;
            for (int i = 0; i < prefix.length(); i++) {
                ch = prefix.charAt(i) - 'a';
                if (cur.son[ch] == null) {
                    return false;
                }
                cur = cur.son[ch];
            }
            return true;
        }
    }

    static class TrieNode {

        private TrieNode[] son;
        private boolean isEnd;
        private int score;
        private List<Integer> ids; // 记录所有的下标

        public TrieNode() {
            isEnd = false;
            son = new TrieNode[26];
            score = 0;
            ids = new ArrayList<>();
        }
    }
}
