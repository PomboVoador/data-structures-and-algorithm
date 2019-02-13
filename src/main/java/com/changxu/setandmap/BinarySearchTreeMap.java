package com.changxu.setandmap;

/**
 * @version 1.0
 * @title: BinarySearchTreeMap
 * @desc: 基于二分搜索树的map
 * @package: com.changxu.setandmap
 * @author: chang.xu
 * @date: 2019/02/09 11:09
 */
public class BinarySearchTreeMap<K extends Comparable<K>, V> implements Map<K, V> {

	private class Node {
		public K key;
		public V value;
		public Node left, right;

		public Node(K key, V value) {
			this.key = key;
			this.value = value;
			left = null;
			right = null;
		}
	}

	/**
	 * 根节点
	 */
	private Node root;

	/**
	 * map的存储键值对数量
	 */
	private int size;


	public BinarySearchTreeMap() {
		root = null;
		size = 0;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public V get(K key) {
		return getNode(root, key) == null ? null : getNode(root, key).value;
	}

	/**
	 * 向二分搜索树中添加新的元素（key, value）
	 * @param key
	 * @param value
	 * @return
	 */
	@Override
	public V put(K key, V value) {
		root = add(root, key, value);
		return root.value;
	}

	/**
	 * 向以node为根的二分搜索树中插入元素（key, value）
	 * 返回插入新节点后二分搜索树的根
	 * @param node
	 * @param key
	 * @param value
	 * @return
	 */
	private Node add(Node node, K key, V value) {
		if (node == null) {
			size ++;
			return new Node(key, value);
		}

		if (key.compareTo(node.key) < 0) {
			node.left = add(node.left, key, value);
		}else if (key.compareTo(node.key) > 0) {
			node.right = add(node.right, key, value);
		}else {
			//key.compareTo(node.key) == 0
			node.value = value;
		}
		return node;
	}

	@Override
	public V remove(V key) {
		return null;
	}

	/**
	 * 从二分搜索树中删除node为根节点下的键为key的节点
	 * @param node
	 * @param key
	 * @return
	 */
	private Node remove(Node node, K key) {
		if (node == null) {
			return null;
		}
		if (key.compareTo(node.key) < 0) {
			node.left = remove(node.left, key);
			return node;
		}else if (key.compareTo(node.key) > 0) {
			node.right = remove(node.right, key);
			return node;
		}else {
			//key.compareTo(node.key) == 0

			//待删除节点左子树为空的情况
			if (node.left == null) {
				Node rightNode = node.right;
				node.right = null;
				size --;
				return rightNode;
			}
			//待删除节点右子树为空的情况
			if (node.right == null) {
				Node leftNode = node.left;
				node.left = null;
				size --;
				return leftNode;
			}

			//待删除节点左右子树均不为空的情况

			//找到比待删除节点大的最小节点,即待删除节点右子树的最小节点
			//用这个节点顶替待删除节点的位置
			Node successor = minimum(node.right);
			successor.right = removeMin(node.right);
			successor.left = node.left;

			node.left = null;
			node.right = null;

			return successor;
		}
	}


	/**
	 * 删除掉以node为根的二分搜索树中的最小节点
	 * 返回删除节点后新的二分搜索树的根
	 * @param node
	 * @return
	 */
	private Node removeMin(Node node) {
		if (node.left == null) {
			Node rightNode = node.right;
			node.right = null;
			size --;
			return rightNode;
		}

		node.left = removeMin(node.left);
		return node;
	}



	/**
	 * 返回以node为根的二分搜索树的最小值所在的节点
	 * @param node
	 * @return
	 */
	private Node minimum(Node node) {
		if (node.left == null) {
			return node;
		}
		return minimum(node.left);
	}


	@Override
	public boolean containsKey(K key) {
		return getNode(root, key) != null;
	}

	@Override
	public void replace(K key, V value) {
		Node node = getNode(root, key);
		if (node == null) {
			throw new IllegalArgumentException(key + "doesn't exist !");
		}
		node.value = value;
	}

	/**
	 * 返回以node为根节点的二分搜索树中,key所在的节点
	 * @param node
	 * @param key
	 * @return
	 */
	private Node getNode(Node node, K key) {
		if (node == null) {
			return null;
		}

		if (key.compareTo(node.key) < 0) {
			return getNode(node.left, key);
		}else if (key.compareTo(node.key) > 0){
			return getNode(node.right, key);
		}else {
			return node;
		}
	}
}
