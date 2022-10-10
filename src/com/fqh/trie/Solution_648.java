package com.fqh.trie;

/**
 * @author The End of Death
 * @version 1.0
 * @since 2022/10/7 14:25:10
 */

import java.util.Arrays;
import java.util.List;

/**
 * 648. 单词替换
 */
public class Solution_648 {

    public static void main(String[] args) {
        List<String> dictionary = Arrays.asList("cat", "bat", "rat");
        String sentence = "the cattle was rattled by the battery";
        System.out.println(new Solution_648().replaceWords(dictionary, sentence));
    }

    //TODO
    public String replaceWords(List<String> dictionary, String sentence) {
        int ch;
        TrieNode root = new TrieNode();
        TrieNode cur = root;
        // 将所有单词添加到字典树
        for (String word : dictionary) {
            cur = root;
            for (int i = 0; i < word.length(); i++) {
                ch = word.charAt(i) - 'a';
                if (cur.next[ch] == null) {
                    cur.next[ch] = new TrieNode();
                }
                cur = cur.next[ch];
            }
            cur.isEnd = true;

        }
        for (String sub : sentence.split(" ")) {
            // 进行前缀替换
            String prefix = isPrefix(root, sub);
            if (!prefix.equals("")) {
                System.out.println("prefix: " + prefix);
                sentence = sentence.replace(sub, prefix);
            }
        }
        return sentence;
    }

    public String isPrefix(TrieNode root, String prefix) {
        int ch;
        TrieNode cur = root;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < prefix.length(); i++) {
            ch = prefix.charAt(i) - 'a';
            if (cur.next[ch] == null) {
                break;
            }
            sb.append(prefix.charAt(i));
            cur = cur.next[ch];
        }

        return cur.isEnd? sb.toString() : prefix;
    }

    static class TrieNode {
        TrieNode[] next;
        boolean isEnd;
        public TrieNode() {
            this.next = new TrieNode[26];
            this.isEnd = false;
        }
    }
}
