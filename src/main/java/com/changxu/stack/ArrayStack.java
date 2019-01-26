package com.changxu.stack;

import com.changxu.array.Array;

/**
 * @version 1.0
 * @title: ArrayStack
 * @desc: 数组栈
 * @package: com.changxu.stack
 * @author: chang.xu
 * @date: 2019/01/25 14:09
 */
public class ArrayStack<E> implements Stack<E> {
	/**
	 * 存储元素的动态数组
	 */
	private Array<E> array;

	/**
	 * 指定固定容量capacity的数组栈
	 * @param capacity
	 */
	public ArrayStack(int capacity) {
		this.array = new Array<E>(capacity);
	}

	public ArrayStack() {
		this.array = new Array<E>();
	}

	@Override
	public int getSize() {
		return array.getSize();
	}

	@Override
	public boolean isEmpty() {
		return array.isEmpty();
	}

	@Override
	public void push(E e) {
		array.addLast(e);
	}

	@Override
	public E pop() {
		return array.removeLast();
	}

	@Override
	public E peek() {
		return array.getLast();
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("Stack: ");
		result.append("[");
		for (int i = 0; i < array.getSize(); i++) {
			result.append(array.get(i));
			if (i != array.getSize() - 1){
				result.append(", ");
			}
		}
		result.append("] top");
		return result.toString();
	}
}
