package com.changxu.trie2;

import java.util.HashMap;

/**
 * @version 1.0
 * @title: Trie
 * @desc: 字典树
 * @package: com.changxu.trie2
 * @author: chang.xu
 * @date: 2019/02/02 11:02
 */
public class Trie {

	private class Node{

		public boolean isWord;
		public HashMap<Character, Node> next;

		public Node(boolean isWord){
			this.isWord = isWord;
			next = new HashMap<Character, Node>();
		}

		public Node(){
			this(false);
		}
	}

	private Node root;
	private int size;

	public Trie(){
		root = new Node();
		size = 0;
	}

	// 获得Trie中存储的单词数量
	public int getSize(){
		return size;
	}

	// 向Trie中添加一个新的单词word
	public void add(String word){

		Node cur = root;
		for(int i = 0 ; i < word.length() ; i ++){
			char c = word.charAt(i);
			if(cur.next.get(c) == null) {
				cur.next.put(c, new Node());
			}
			cur = cur.next.get(c);
		}

		if(!cur.isWord){
			cur.isWord = true;
			size ++;
		}
	}

	// 查询单词word是否在Trie中
	public boolean contains(String word){

		Node cur = root;
		for(int i = 0 ; i < word.length() ; i ++){
			char c = word.charAt(i);
			if(cur.next.get(c) == null) {
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