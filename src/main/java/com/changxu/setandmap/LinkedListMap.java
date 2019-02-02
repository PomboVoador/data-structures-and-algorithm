package com.changxu.setandmap;

/**
 * @version 1.0
 * @title: LinkedListMap
 * @desc: 链表map
 * @package: com.changxu.setandmap
 * @author: chang.xu
 * @date: 2019/01/29 17:00
 */
public class LinkedListMap<K, V> implements Map<K, V> {

	private class Node{
		/**
		 * 节点中的key
		 */
		public K key;
		/**
		 * 节点中key对应的value
		 */
		public V value;

		public Node next;

		public Node(K key, V value, Node next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}

		public Node(K key, V value) {
			this(key, value, null);
		}

		public Node() {
			this(null, null, null);
		}
	}

	/**
	 * 虚拟头结点
	 */
	private Node dummyHead;

	/**
	 * 获取当前map的键值对数量
	 */
	private int size;

	public LinkedListMap() {
		this.dummyHead = new Node();
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
		Node node = getNode(key);
		return node == null ? null: node.value;
	}

	/**
	 * 获取key对应的node节点
	 * @param key
	 * @return
	 */
	private Node getNode(K key){
		Node currentNode = dummyHead.next;
		while (currentNode != null){
			if (currentNode.key.equals(key)){
				return currentNode;
			}
			currentNode = currentNode.next;
		}
		return null;
	}


	@Override
	public V put(K key, V value) {
		Node node = getNode(key);
		if (node == null){
//			Node newNode = new Node(key, value);
//			newNode.next = dummyHead.next;
//			dummyHead.next = newNode;
			dummyHead.next = new Node(key,value, dummyHead.next);
			size ++;
			return null;
		}else {
			V oldValue = node.value;
			node.value = value;
			return oldValue;
		}
	}

	@Override
	public V remove(V key) {
		Node prev = this.dummyHead;
		while (prev.next != null){
			if (prev.next.key.equals(key)){
				break;
			}
			prev = prev.next;
		}
		if (prev.next != null){
			Node delNode = prev.next;
			prev.next = delNode.next;
			dummyHead.next = null;
			size --;
			return delNode.value;
		}
		return null;
	}

	@Override
	public boolean containsKey(K key) {
		return getNode(key) != null;
	}

	@Override
	public void replace(K key, V value) {
		Node node = getNode(key);
		if (node == null){
			throw new IllegalArgumentException(key + "doesn't exist.");
		}else {
			node.value = value;
		}
	}
}
