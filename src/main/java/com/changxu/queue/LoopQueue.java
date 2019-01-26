package com.changxu.queue;

/**
 * @version 1.0
 * @title: LoopQueue
 * @desc: 循环队列
 * @package: com.changxu.queue
 * @author: chang.xu
 * @date: 2019/01/26 10:31
 */
public class LoopQueue<E> implements Queue<E> {

	/**
	 * 默认的初始化容量
	 */
	private static final int DEFAULT_CAPACITY = 10;

	private static final int DOUBLE = 2;

	/**
	 * 存储队列的数组
	 */
	private E[] data;
	/**
	 * 队首的索引
	 */
	private int front;
	/**
	 * 下一个元素入队应该存储的元素位置
	 */
	private int tail;
	/**
	 * 队列的大小
	 */
	private int size;

	public LoopQueue(int capacity) {
		data = (E[]) new Object[capacity];
	}

	/**
	 * 无参的构造方法（初始的容量为10）
	 */
	public LoopQueue() {
		this(DEFAULT_CAPACITY);
	}

	public int getCapacity(){
		return data.length - 1;
	}

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return front == tail;
	}

	@Override
	public void enqueue(E e) {
		if ((tail + 1) % data.length == front){
			resize(getCapacity() * DOUBLE);
		}
		data[tail] = e;
		tail = (tail + 1) % data.length;
		size ++;
	}

	@Override
	public E dequeue() {
		if (isEmpty()){
			throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
		}
		E ret = data[front];
		data[front] = null;
		front = (front + 1) % data.length;
		size --;
		if (size == getCapacity() / (DOUBLE * DOUBLE) && getCapacity() / DOUBLE != 0){
			resize(getCapacity() / DOUBLE);
		}
		return ret;
	}

	@Override
	public E getFront() {
		if (isEmpty()){
			throw new IllegalArgumentException("Queue is empty");
		}
		return data[front];
	}

	/**
	 * 重新调整对象容器的大小
	 * @param newCapacity
	 */
	private void resize(int newCapacity){
		E[] newData = (E[]) new Object[newCapacity];
		for (int i = 0; i < size; i++) {
			newData[i] = data[(i + front) % data.length];
		}
		data = newData;
		front = 0;
		tail = size;
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("Queue: size = %d, capacity = %d\n", size, getCapacity());
		result.append("front [");
		for (int i = 0; i != tail; i = (i + 1) % data.length) {
			result.append(data[i]);
			if ((i + 1) % data.length != tail){
				result.append(", ");
			}
		}
		return result.toString();
	}
}
