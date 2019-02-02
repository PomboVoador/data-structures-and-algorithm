package com.changxu.leetcode.problem641;


import java.util.LinkedList;
import java.util.Queue;

/**
 * @version 1.0
 * @title: MyCircularDeque
 * @desc: 双端队列
 * @package: com.changxu.leetcode.problem641
 * @author: chang.xu
 * @date: 2019/01/31 9:36
 */
public class MyCircularDeque<E> {

	private Node front;

	private Node rear;

	private int capacity;

	private int size;

	/** Initialize your data structure here. Set the size of the deque to be k. */
	public MyCircularDeque(int k) {
		front = null;
		rear = null;
		capacity = k;
		size = 0;
	}

	/** Adds an item at the front of Deque. Return true if the operation is successful. */
	public boolean insertFront(int value) {
		Node node = insert(value);
		if (node == null){
			return false;
		}
		front = node;
		return true;
	}


	/** Adds an item at the rear of Deque. Return true if the operation is successful. */
	public boolean insertLast(int value) {
		Node node = insert(value);
		if (node == null){
			return false;
		}
		rear =node;
		return true;
	}

	private Node insert(int value){
		if (isFull()){
			return null;
		}
		Node node = new Node(value);
		if (front == null){
			node.prev = node;
			node.next = node;
			front = node;
			rear = node;
		}else {
			rear.next = node;
			node.prev = rear;
			node.next = front;
			front.prev = node;
		}
		size ++;
		return node;
	}

	/** Deletes an item from the front of Deque. Return true if the operation is successful. */
	public boolean deleteFront() {
		if (isEmpty()){
			return false;
		}
		if (size == 1) {
			front = null;
			rear = null;
		} else {
			front = front.next;
			rear.next = front;
			front.prev =rear;
		}
		size --;
		return true;
	}

	/** Deletes an item from the rear of Deque. Return true if the operation is successful. */
	public boolean deleteLast() {
		if (isEmpty()){
			return false;
		}
		if (size == 1){
			front = null;
			rear = null;
		} else {
			rear = rear.prev;
			rear.next = front;
			front.prev = rear;
		}
		size --;
		return true;
	}

	/** Get the front item from the deque. */
	public int getFront() {
		int result = -1;
		if (!isEmpty()) {
			result = front.data;
		}
		return result;
	}

	/** Get the last item from the deque. */
	public int getRear() {
		int result = -1;
		if (!isEmpty()){
			result = rear.data;
		}
		return result;
	}

	/** Checks whether the circular deque is empty or not. */
	public boolean isEmpty() {
		return size == 0;
	}

	/** Checks whether the circular deque is full or not. */
	public boolean isFull() {
		return size == capacity;
	}

}


class Node{
	int data;
	Node next;
	Node prev;

	public Node(int data) {
		this.data = data;
		next = null;
		prev = null;
	}
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */