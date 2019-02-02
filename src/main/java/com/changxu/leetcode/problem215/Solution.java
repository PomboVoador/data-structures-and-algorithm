package com.changxu.leetcode.problem215;

import java.util.PriorityQueue;

/**
 * @version 1.0
 * @title: Solution
 * @desc:
 * @package: com.changxu.leetcode.problem215
 * @author: chang.xu
 * @date: 2019/01/30 16:43
 */
public class Solution {

	private PriorityQueue<Integer> priorityQueue;

	private int k;

	public int findKthLargest(int[] nums, int k) {
		this.k = k;
		priorityQueue = new PriorityQueue<Integer>(k);
		for (int num: nums){
			add(num);
		}
		return priorityQueue.peek();
	}


	private int add(int val){
		if (priorityQueue.size() < k){
			priorityQueue.add(val);
		}else if (priorityQueue.peek() < val){
			priorityQueue.poll();
			priorityQueue.add(val);
		}
		return priorityQueue.peek();
	}
}
