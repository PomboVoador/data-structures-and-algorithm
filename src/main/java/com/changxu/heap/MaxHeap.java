package com.changxu.heap;

import com.changxu.array.Array;

/**
 * @version 1.0
 * @title: MaxHeap
 * @desc: 最大堆
 * @package: com.changxu.heap
 * @author: chang.xu
 * @date: 2019/01/29 18:26
 */
public class MaxHeap<E extends Comparable> {

	private Array<E> data;


	public MaxHeap(int capacity) {
		this.data = new Array<E>();
	}

	public MaxHeap() {
		data = new Array<E>();
	}

	public MaxHeap(E[] arr){
		data = new Array<E>(arr);
		for (int i = parent(arr.length - 1); i >= 0; i--) {
			siftDown(i);
		}
	}

	/**
	 * 返回堆中元素个数
	 * @return
	 */
	public int size(){
		return data.getSize();
	}

	/**
	 * 返回一个布尔值,表示堆中是否为空
	 * @return
	 */
	public boolean isEmpty(){
		return data.isEmpty();
	}

	/**
	 * 返回二叉树的数组表示,一个索引所宝石的元素的父亲节点的索引
	 * @param index
	 * @return
	 */
	private int parent(int index){
		if (index == 0){
			throw new IllegalArgumentException("index-0 doesn't have parent.");
		}
		return (index - 1) / 2;
	}

	/**
	 * 返回完全二叉树中的数组表示中,一个索引所表示的元素的左孩子节点的索引
	 * @param index
	 * @return
	 */
	private int leftChild(int index){
		return index * 2 + 1;
	}

	/**
	 * 返回完全二叉树中的数据表示中,一个索引所表示的右孩子节点的索引
	 * @param index
	 * @return
	 */
	private int rightChild(int index){
		return index * 2 + 2;
	}

	/**
	 * 下沉
	 * @param k
	 */
	private void siftDown(int k){
		while (leftChild(k) < data.getSize()){
			int j = leftChild(k);
			if (j + 1 < data.getSize() && data.get(j + 1).compareTo(data.get(j)) > 0){
				//j ++;
				j = rightChild(k);
			}
			//data[j]是data[leftChild]和data[rigthChild]中的最大值
			if (data.get(k).compareTo(data.get(j)) >= 0){
				break;
			}
			data.swap(k, j);
			k = j;
		}
	}

	/**
	 * 向堆中添加元素
	 * @param e 待添加的元素
	 */
	public void add(E e){
		data.addLast(e);
		siftUp(data.getSize() - 1);
	}

	/**
	 * 对应索引元素上浮
	 * @param k
	 */
	private void siftUp(int k){
		while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0){
			data.swap(k, parent(k));
			k = parent(k);
		}
	}

	/**
	 * 查看堆中的最大元素
	 * @return
	 */
	public E findMax(){
		if (data.getSize() == 0){
			throw new IllegalArgumentException("Cannot not findMax when the heap is empty.");
		}
		return data.get(0);
	}

	/**
	 *
	 * @return
	 */
	public E extractMax(){
		//交换data[0]和data[arr.size - 1]的值
		//删除掉data[arr.size - 1]的值
		//data[0]元素下沉
		E ret = findMax();

		data.swap(0, data.getSize() - 1);
		data.removeLast();
		siftDown(0);

		return ret;
	}

	/**
	 * 取出堆中的最大元素,并且替换成元素e
	 * @param e
	 * @return
	 */
	public E replace(E e){
		E ret = findMax();
		data.set(0, e);
		siftDown(0);
		return ret;
	}










}
