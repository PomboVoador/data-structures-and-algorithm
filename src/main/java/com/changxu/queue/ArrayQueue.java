package com.changxu.queue;

import com.changxu.array.Array;

/**
 * @version 1.0
 * @title: ArrayQueue
 * @desc: 数组队列
 * @package: com.changxu.queue
 * @author: chang.xu
 * @date: 2019/01/25 18:10
 */
public class ArrayQueue<E> implements Queue<E> {

	private Array<E> array;

	public ArrayQueue() {
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
	public void enqueue(E e) {
		array.addLast(e);
	}

	@Override
	public E dequeue() {
		return array.removeFirst();
	}

	@Override
	public E getFront() {
		return array.getFirst();
	}


	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("Queue: ");
		result.append("front [");
		for (int i = 0; i < array.getSize(); i++) {
			result.append(array.get(i));
			if (i != array.getSize() - 1){
				result.append(", ");
			}
		}
		result.append("] tail");
		return result.toString();
	}
}
