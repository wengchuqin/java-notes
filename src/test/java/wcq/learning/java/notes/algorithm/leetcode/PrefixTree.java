package wcq.learning.java.notes.algorithm.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

/**
 * 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
 * 题目：https://leetcode-cn.com/explore/interview/card/top-interview-quesitons/275/string/1140/
 *
 * @author: wengchuqin
 * @create: 2020-04-05 16:58
 */
public class PrefixTree {
    @Test
    public void test() {
        Trie trie = new Trie();
        trie.insert("apple");
        Assert.assertTrue(trie.search("apple"));
        Assert.assertFalse(trie.search("app"));


        Assert.assertTrue(trie.startsWith("apple"));
        Assert.assertTrue(trie.startsWith("app"));


        trie.insert("app");
        Assert.assertTrue(trie.search("app"));

        Assert.assertTrue(trie.startsWith("apple"));
        Assert.assertTrue(trie.startsWith("app"));
    }


    class Trie {
        Node root = new Node(null, false);

        /**
         * Initialize your data structure here.
         */
        public Trie() {

        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            HashMap<Character, Node> nodes = root.children;
            Node last = null;
            for (char c : word.toCharArray()) {
                Node node = nodes.get(c);
                if (node == null) {
                    node = new Node(c, false);
                    nodes.put(c, node);
                }
                nodes = node.children;
                last = node;
            }
            last.word = true;
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            Node last = findNode(word);
            return last != null && last.word;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            Node last = findNode(prefix);
            return last != null;
        }

        private Node findNode(String word) {
            HashMap<Character, Node> nodes = root.children;
            Node last = null;
            for (char c : word.toCharArray()) {
                Node node = nodes.get(c);
                if (node == null) {
                    return null;
                }
                nodes = node.children;
                last = node;
            }
            return last;
        }

        class Node {
            Character c;
            boolean word;
            HashMap<Character, Node> children;

            public Node(Character c, boolean word) {
                this.c = c;
                this.word = word;
                this.children = new HashMap<>();
            }

        }
    }


}

