package com.changxu.leetcode.problem703;

import java.util.PriorityQueue;

/**
 * Design a class find the kth largest element in a stream,Note that it is the kth largest element
 * in the sorted order,not the kth distinct element.
 *
 * Your KthLargest class will have a constructor which accepts an integer k
 * and an integer array nums,which contains initail elements from the stream,
 * For each call to the method KthLargest.add, return the element representing
 * the kth largest element in the stream.
 *
 * @version 1.0
 * @title: KthLargest
 * @desc: 703. Kth Largest Element in a Stream
 * @package: leetcode
 * @author: chang.xu
 * @date: 2019/01/30 15:44
 */
public class KthLargest {

	private final PriorityQueue<Integer> priorityQueue;
	private final int k;


	public KthLargest(int k, int[] nums) {
		this.k = k;
		priorityQueue = new PriorityQueue<Integer>(k);
		for (int n : nums){
			add(n);
		}
	}

	/**
	 * 添加元素
	 * @param val
	 * @return
	 */
	public int add(int val) {
		if (priorityQueue.size() < k){
			priorityQueue.offer(val);
		}else if (priorityQueue.peek() < val){
			priorityQueue.poll();
			priorityQueue.offer(val);
		}
		return priorityQueue.peek();
	}
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */