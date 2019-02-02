package com.changxu.queue;

import com.changxu.heap.MaxHeap;
import com.changxu.queue.Queue;

/**
 * @version 1.0
 * @title: PriorityQueue
 * @desc: 优先队列
 * @package: queue
 * @author: chang.xu
 * @date: 2019/01/30 14:41
 */
public class PriorityQueue<E extends Comparable<E>> implements Queue<E> {

	private MaxHeap<E> maxHeap;


	public PriorityQueue() {
		maxHeap = new MaxHeap<E>();
	}

	@Override
	public int getSize() {
		return maxHeap.size();
	}

	@Override
	public boolean isEmpty() {
		return maxHeap.isEmpty();
	}

	@Override
	public void enqueue(E e) {
		maxHeap.add(e);
	}

	@Override
	public E dequeue() {
		return maxHeap.extractMax();
	}

	@Override
	public E getFront() {
		return maxHeap.findMax();
	}
}
