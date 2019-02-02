package com.changxu.trie3;

/**
 * @version 1.0
 * @title: Trie
 * @desc:
 * @package: com.changxu.trie3
 * @author: chang.xu
 * @date: 2019/02/02 15:03
 */
public class Trie {

	public static final int SYMBOLS = 26;


	private class Node {
		/**
		 * 是否是单词
		 */
		public boolean isWord;

		/**
		 * 下个节点
		 */
		public Node[] next;

		public Node(boolean isWord) {
			this.isWord = isWord;
			next = new Node[SYMBOLS];
		}

		public Node() {
			this(false);
		}
	}

	public Trie() {
		root = new Node();
		size = 0;
	}

	/**
	 * 根节点
	 */
	private Node root;

	/**
	 * 字典树容量大小
	 */
	private int size;

	/**
	 * 获得Trie中存储的单词数量
	 * @return
	 */
	public int getSize() {
		return size;
	}

	/**
	 * 向Trie中添加一个新的单词word
	 * @param word
	 */
	public void add(String word) {
		Node cur = this.root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (cur.next[c - 'a'] == null) {
				cur.next[c - 'a'] = new Node();
			}
			cur = cur.next[c - 'a'];
		}

		if (!cur.isWord) {
			cur.isWord = true;
			size ++;
		}
	}

	/**
	 * 查看单词word是否在word中
	 * @param word
	 * @return
	 */
	public boolean contains(String word) {
		Node cur = this.root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (cur.next[c - 'a'] == null) {
				return false;
			}
			cur = cur.next[c - 'a'];
		}
		return cur.isWord;
	}


	/**
	 * 查看是否在Trie中有单词以prefix为前缀
	 * @param prefix
	 * @return
	 */
	public boolean isPrefix(String prefix){
		Node cur = this.root;
		for (int i = 0; i < prefix.length(); i++) {
			char c = prefix.charAt(i);
			if (cur.next[c - 'a'] == null){
				return false;
			}
			cur = cur.next[c - 'a'];
		}
		return true;
	}



}
