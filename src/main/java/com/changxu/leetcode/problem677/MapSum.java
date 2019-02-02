package com.changxu.leetcode.problem677;

import java.util.TreeMap;

/**
 * @version 1.0
 * @title: MapSum
 * @desc:
 * @package: com.changxu.leetcode.problem677
 * @author: chang.xu
 * @date: 2019/02/01 17:17
 */
public class MapSum {

	private Node root;

	/** Initialize your data structure here. */
	public MapSum() {
		root = new Node();
	}

	public void insert(String key, int val) {
		Node cur = this.root;
		for (int i = 0; i < key.length(); i++) {
			char c = key.charAt(i);
			if (cur.next.get(c) == null) {
				cur.next.put(c, new Node());
			}
			cur = cur.next.get(c);
		}
		cur.value = val;
	}

	public int sum(String prefix) {
		Node cur = this.root;
		for (int i = 0; i < prefix.length(); i++) {
			char c = prefix.charAt(i);
			if (cur.next.get(c) == null) {
				return 0;
			}
			cur = cur.next.get(c);
		}
		return sum(cur);
	}

	private int sum(Node node) {
//		if (node.next.size() == 0) {
//			return node.value;
//		}
		int res = node.value;
		for (char c: node.next.keySet()) {
			res += sum(node.next.get(c));
		}
		return res;
	}


	private class Node {

		private int value;

		public TreeMap<Character, Node> next;

		public Node(int value) {
			this.value = value;
			next = new TreeMap<Character, Node>();
		}

		public Node() {
			this(0);
		}
	}
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
