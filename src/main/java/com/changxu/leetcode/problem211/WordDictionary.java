package com.changxu.leetcode.problem211;

import java.util.TreeMap;

/**
 * @version 1.0
 * @title: WordDictionary
 * @desc: 单词字典
 * @package: com.changxu.leetcode.problem211
 * @author: chang.xu
 * @date: 2019/02/01 16:06
 */
public class WordDictionary {

	/**
	 * 根节点
	 */
	private Node root;

	/**
	 * 字典树的容量大小
	 */
	private int size;

	/** Initialize your data structure here. */
	public WordDictionary() {
		root = new Node();
		size = 0;
	}

	/** Adds a word into the data structure. */
	public void addWord(String word) {
		Node cur = this.root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (cur.next.get(c) == null) {
				cur.next.put(c, new Node());
			}
			cur = cur.next.get(c);
		}
		if (!cur.isWord) {
			cur.isWord = true;
			size ++;
		}
	}

	/** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
	public boolean search(String word) {
		return match(root, word, 0);
	}


	public boolean match(Node node, String word, int index) {
		if (index == word.length()) {
			return node.isWord;
		}

		char c = word.charAt(index);

		if (c != '.') {
			if (node.next.get(c) == null) {
				return false;
			}
			return match(node.next.get(c), word, index + 1);
		}else {
			for (char nextChar: node.next.keySet()) {
				if (match(node.next.get(nextChar), word, index + 1)) {
					return true;
				}
			}
			return false;
		}
	}




	private class Node {
		/**
		 * 该节点是否为单词的节点
		 */
		public boolean isWord;

		/**
		 * 存储字符串
		 */
		public TreeMap<Character, Node> next;


		public Node(boolean isWord) {
			this.isWord = isWord;
			next = new TreeMap<Character, Node>();
		}

		public Node() {
			this(false);
		}
	}

}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */