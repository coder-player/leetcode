package com.fqh.hot;

/**
 * @author 我劝你荔枝_FQH
 * @version 1.0
 * Date: 2022/7/22 22:21:58
 */
public class Solution_208 {

    public static void main(String[] args) {

    }

    class Trie {
        class TrieNode {
            boolean end;
            TrieNode[] tns = new TrieNode[26];
        }

        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String s) {
            TrieNode p = root;
            for (int i = 0; i < s.length(); i++) {
                int u = s.charAt(i) - 'a';
                if (p.tns[u] == null) p.tns[u] = new TrieNode();
                p = p.tns[u];
            }
            p.end = true;
        }

        public boolean search(String s) {
            TrieNode p = root;
            for (int i = 0; i < s.length(); i++) {
                int u = s.charAt(i) - 'a';
                if (p.tns[u] == null) return false;
                p = p.tns[u];
            }
            return p.end;
        }

        public boolean startsWith(String s) {
            TrieNode p = root;
            for (int i = 0; i < s.length(); i++) {
                int u = s.charAt(i) - 'a';
                if (p.tns[u] == null) return false;
                p = p.tns[u];
            }
            return true;
        }
    }
}
