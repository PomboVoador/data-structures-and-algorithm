package com.changxu.queue;

import com.changxu.linkedlist.LinkedList;

/**
 * @version 1.0
 * @title: LinkedListQueue
 * @desc: 链表队列
 * @package: com.changxu.queue
 * @author: chang.xu
 * @date: 2019/01/26 10:02
 */
public class LinkedListQueue<E> implements Queue<E> {

	/**
	 * 存储元素的内部类节点
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

		@Override
		public String toString() {
			return e.toString();
		}
	}

	/**
	 * 队首元素
	 */
	private Node head;

	/**
	 * 队尾元素
	 */
	private Node tail;

	/**
	 * 队列容器的大小
	 */
	private int size;

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public void enqueue(E e) {
		if (tail == null){
			tail = new Node(e);
			head = tail;
		}else {
			tail.next = new Node(e);
			tail = tail.next;
		}
		size ++;
	}

	@Override
	public E dequeue() {
		if (isEmpty()){
			throw new IllegalArgumentException("Cannot dequeue from an empty queue");
		}

		Node ret = this.head;
		head = head.next;
		ret.next = null;
		//边界条件（未出队之前,head == tail）
		if (head == null){
			tail = null;
		}
		size --;
		return ret.e;
	}

	@Override
	public E getFront() {
		if (isEmpty()){
			throw new IllegalArgumentException("Queue is empty.");
		}
		return head.e;
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("Queue: front ");
		Node cur = this.head;
		while (cur != null){
			result.append(cur.e).append("->");
			cur = cur.next;
		}
		result.append("NULL tail");
		return result.toString();
	}
}
