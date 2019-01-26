package com.changxu.linkedlist;

/**
 * @version 1.0
 * @title: LinkedList
 * @desc: 链表
 * @package: com.changxu.linkedlist
 * @author: chang.xu
 * @date: 2019/01/25 14:20
 */
public class LinkedList<E> {
	/**
	 * 内部类节点
	 */
	private class Node{
		private E e;
		private Node next;

		public Node(E e, Node next) {
			this.e = e;
			this.next = next;
		}

		public Node(E e) {
			this(e, null);
		}

		public Node() {
			this(null, null);
		}

		@Override
		public String toString() {
			return e.toString();
		}
	}

	/**
	 * 虚拟头结点
	 */
	private Node dummyHead;

	/**
	 * 链表大小
	 */
	private int size;

	public LinkedList() {
		dummyHead = new Node(null, null);
		size = 0;
	}

	/**
	 * 获取链表中的元素个数
	 * @return
	 */
	public int getSize(){
		return size;
	}

	/**
	 * 返回链表是否为空
	 * @return
	 */
	public boolean isEmpty(){
		return size == 0;
	}

	/**
	 * 查找链表中是否有元素e
	 * @param e 要查找的元素
	 * @return
	 */
	public boolean contains(E e){
		Node currentNode = dummyHead.next;
		while (currentNode.next != null){
			if (currentNode.e.equals(e)){
				return true;
			}
		}
		return false;
	}


	/**
	 * 在链表表头添加新的元素
	 * @param e 待添加的元素
	 */
	public void addFirst(E e){
		add(0, e);
	}

	/**
	 * 在链表的index(0-baseed)位置
	 * 在链表中不是一个常用的操作,练习用
	 * @param index
	 * @param e
	 */
	public void add(int index, E e){
		if (index < 0 || index > size){
			throw new IllegalArgumentException("Add failed.Illegal index.");
		}
		Node prev = this.dummyHead;
		for (int i = 0; i < index; i++) {
			prev = prev.next;
		}

//		Node node = new Node(e);
//		node.next = prev.next;
//		prev.next = node;

		prev.next = new Node(e, prev.next);
		size ++;
	}

	/**
	 * 在链表末尾添加新的元素
	 * @param e
	 */
	public void addLast(E e){
		add(size, e);
	}

	/**
	 * 获得链表的第index(0-based)个位置的元素
	 * 在链表中不是一个常用的操作,练习用
	 * @param index
	 * @return
	 */
	public E get(int index){
		if (index < 0 || index >= size){
			throw new IllegalArgumentException("Get failed.Index is illegal.");
		}
		Node currentNode = dummyHead.next;
		for (int i = 0; i < index; i++) {
			currentNode = currentNode.next;
		}
		return currentNode.e;
	}

	/**
	 * 获取链表的第一个元素
	 * @return
	 */
	public E getFirst(){
		return get(0);
	}

	/**
	 * 获取链表的最后一个元素
	 * @return
	 */
	public E getLast(){
		return get(size - 1);
	}

	/**
	 * 修改链表的第index(0-based)个位置的元素为e
	 * 在链表中一个常用的操作,练习用
	 * @param index
	 * @param e
	 */
	public void set(int index, E e){
		if (index < 0 || index >= size){
			throw new IllegalArgumentException("Set failed.Index is illegal.");
		}
		Node currentNode = dummyHead.next;
		for (int i = 0; i < index; i++) {
			currentNode = currentNode.next;
		}
		currentNode.e = e;
	}

	/**
	 * 在链表中删除index(0-based)的元素,返回删除的元素
	 * @param index
	 * @return
	 */
	public E remove(int index){
		if (index < 0 || index >= size){
			throw new IllegalArgumentException("Remove failed.Index is illegal.");
		}
		Node prev = this.dummyHead;
		for (int i = 0; i < index; i++) {
			prev = prev.next;
		}

		Node returnNode = prev.next;
		prev.next = returnNode.next;

		returnNode.next = null;
		size --;
		return returnNode.e;
	}

	/**
	 * 在链表中删除第一个元素,返回删除的元素
	 * @return
	 */
	public E removeFirst(){
		E remove = remove(0);
		return remove;
	}

	/**
	 * 在链表中删除最后一个元素,返回删除的元素
	 * @return
	 */
	public E removeLast(){
		E remove = remove(size - 1);
		return remove;
	}

	/**
	 * 从链表中删除元素e
	 * @param e
	 */
	public void removeElement(E e){
		Node prev = this.dummyHead;
		while (prev.next != null){
			if (prev.next.e.equals(e)){
				break;
			}
			prev = prev.next;
		}
		if (prev.next != null){
			Node delNode = prev.next;
			prev.next = delNode.next;
			delNode.next = null;
			size --;
		}
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		for (Node currentNode = dummyHead.next; currentNode != null; currentNode = currentNode.next){
			result.append(currentNode).append("->");
		}
		result.append("NULL");
		return result.toString();
	}
}
