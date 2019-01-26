package com.changxu.queue;

/**
 * @version 1.0
 * @title: Queue
 * @desc: 队列
 * @package: com.changxu.queue
 * @author: chang.xu
 * @date: 2019/01/25 18:05
 */
public interface Queue<E> {

	/**
	 * 获取队列容量的大小
	 * @return
	 */
	int getSize();

	/**
	 * 判断队列是否为空
	 * @return
	 */
	boolean isEmpty();

	/**
	 * 元素入队
	 * @param e
	 */
	void enqueue(E e);

	/**
	 * 元素出队
	 * @return
	 */
	E dequeue();

	/**
	 * 获取队首对象
	 * @return
	 */
	E getFront();
}
