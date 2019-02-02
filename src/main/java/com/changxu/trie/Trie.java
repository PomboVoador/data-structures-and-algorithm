package com.changxu.trie;

import java.util.TreeMap;

/**
 * @version 1.0
 * @title: Trie
 * @desc: 字典树
 * @package: com.changxu.trie
 * @author: chang.xu
 * @date: 2019/01/30 18:09
 */
public class Trie {

	private class Node{

		public boolean isWord;

		public TreeMap<Character, Node> next;

		public Node(boolean isWord) {
			this.isWord = isWord;
			next = new TreeMap<Character, Node>();
		}

		public Node() {
			this(false);
		}
	}

	/**
	 * 根节点
	 */
	private Node root;

	/**
	 * 字典树的容量大小
	 */
	private int size;

	public Trie() {
		root = new Node();
		size = 0;
	}

	/**
	 * 获得Trie中存储的单词数量
	 * @return
	 */
	public int getSize(){
		return size;
	}

	/**
	 * 向Trie中添加一个新的单词word
	 * @param word
	 */
	public void add(String word){
		Node cur = this.root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (cur.next.get(c) == null){
				cur.next.put(c, new Node());
			}
			cur = cur.next.get(c);
		}
		if (!cur.isWord){
			cur.isWord = true;
			size ++;
		}
	}

	/**
	 * 查看单词word是否在Trie中
	 * @param word
	 * @return
	 */
	public boolean contains(String word){
		Node cur = this.root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (cur.next.get(c) == null){
				return false;
			}
			cur = cur.next.get(c);
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
			if (cur.next.get(c) == null){
				return false;
			}
			cur = cur.next.get(c);
		}
		return true;
	}
}
