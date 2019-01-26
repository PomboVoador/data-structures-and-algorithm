package com.changxu.stack;

import com.changxu.linkedlist.LinkedList;

/**
 * @version 1.0
 * @title: LinkedListStack
 * @desc: 链表栈
 * @package: com.changxu.stack
 * @author: chang.xu
 * @date: 2019/01/25 17:24
 */
public class LinkedListStack<E> implements Stack<E> {

	/**
	 * 存储元素的链表
	 */
	private LinkedList<E> list;

	@Override
	public int getSize() {
		return list.getSize();
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public void push(E e) {
		list.addFirst(e);
	}

	@Override
	public E pop() {
		return list.removeFirst();
	}

	@Override
	public E peek() {
		return list.getFirst();
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("Stack: top ");
		result.append(list);
		return result.toString();
	}
}
