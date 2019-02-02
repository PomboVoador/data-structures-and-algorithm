package com.changxu.leetcode.problem208;

import java.util.TreeMap;

/**
 * @version 1.0
 * @title: Trie
 * @desc:
 * @package: com.changxu.leetcode.problem208
 * @author: chang.xu
 * @date: 2019/02/01 10:21
 */
public class Trie {

	/**
	 * 根节点
	 */
	private Node root;

	/**
	 * 字典树的容量大小
	 */
	private int size;

	/** Initialize your data structure here. */
	public Trie() {
		root = new Node();
		size = 0;
	}

	/** Inserts a word into the trie. */
	public void insert(String word) {
		Node cur = root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (cur.next.get(c) == null){
				cur.next.put(c, new Node());
			}
			cur = cur.next.get(c);
		}
		if (!cur.isWord) {
			cur.isWord = true;
			size ++;
		}
	}

	/** Returns if the word is in the trie. */
	public boolean search(String word) {
		Node cur = root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (cur.next.get(c) == null) {
				return false;
			}
			cur = cur.next.get(c);
		}
		return cur.isWord;
	}

	/** Returns if there is any word in the trie that starts with the given prefix. */
	public boolean startsWith(String prefix) {
		Node cur = root;
		for (int i = 0; i < prefix.length(); i++) {
			char c = prefix.charAt(i);
			if (cur.next.get(c) == null){
				return false;
			}
			cur = cur.next.get(c);
		}
		return true;
	}

	public int getSize() {
		return size;
	}

	private class Node {
		private boolean isWord;

		private TreeMap<Character, Node> next;

		public Node(boolean isWord) {
			this.isWord = isWord;
			this.next = new TreeMap<Character, Node>();
		}

		public Node() {
			this(false);
		}
	}
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */