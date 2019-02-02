package com.changxu.segmenttree;

/**
 * @version 1.0
 * @title: SegmentTree
 * @desc: 线段树
 * @package: com.changxu.segmenttree
 * @author: chang.xu
 * @date: 2019/01/30 17:23
 */
public class SegmentTree<E> {

	private E[] tree;

	private E[] data;

	private Merger<E> merger;

	public SegmentTree(E[] arr, Merger<E> merger) {
		this.merger = merger;

		data = (E[])new Object[arr.length];
		for (int i = 0; i < arr.length; i++) {
			data[i] = arr[i];
		}

		tree = (E[])new Object[4 * arr.length];

		buildSegementTree(0, 0, data.length - 1);


	}

	/**
	 * 在treeIndex的位置创建表示区间[left...right]的线段树
	 * @param treeIndex
	 * @param left
	 * @param right
	 */
	private void buildSegementTree(int treeIndex, int left, int right){
		if (left == right){
			tree[treeIndex] = data[left];
			return;
		}

		int leftChildIndex = leftChildIndex(treeIndex);
		int rightChildIndex = rightChildIndex(treeIndex);

		int middle = left + (right - left) / 2;
		buildSegementTree(leftChildIndex, left, middle);
		buildSegementTree(rightChildIndex, middle + 1, right);

		tree[treeIndex] = merger.merge(tree[leftChildIndex], tree[rightChildIndex]);
	}

	public int getSize(){
		return data.length;
	}

	public E get(int index){
		if (index < 0 || index >= data.length){
			throw new IllegalArgumentException("Index is illegal.");
		}
		return data[index];
	}

	/**
	 * 返回区间【queryL, queryR】的值
	 * @param queryL
	 * @param queryR
	 * @return
	 */
	public E query(int queryL, int queryR){
		if (queryL < 0 || queryR >= data.length){
			throw new IllegalArgumentException("Index is illegal.");
		}
		return query(0, 0, data.length - 1, queryL, queryR);
	}

	/**
	 * 在以treeIndex为根的线段树中【left...right】的范围里,搜索区间
	 * @param treeIndex
	 * @param left
	 * @param right
	 * @return
	 */
	private E query(int treeIndex, int left, int right, int queryL, int queryR){
		if (left == queryL && right == queryR){
			return tree[treeIndex];
		}

		int middle = left + (right - left) / 2;
		//treeIndex的节点为【left...middle】和【middle + 1 ... right】两部分
		int leftChildIndex = leftChildIndex(treeIndex);
		int rightChildIndex = rightChildIndex(treeIndex);
		if (queryL >= middle + 1){
			return query(rightChildIndex, middle + 1, right, queryL, queryR);
		}else if (queryR <= middle){
			return query(treeIndex, left, middle, queryL, queryR);
		}
		E leftResult = query(leftChildIndex, left, middle, queryL, middle);
		E rightResult = query(rightChildIndex, middle + 1, right, middle + 1, queryR);
		return merger.merge(leftResult, rightResult);
	}

	/**
	 * 返回完全二叉树的数组表示中,一个索引所表示的元素的左孩子节点的索引
	 * @param index
	 * @return
	 */
	private int leftChildIndex(int index){
		return index * 2 + 1;
	}

	/**
	 * 返回完全二叉树中数组表示中,一个索引所表示的元素的右孩子节点的索引
	 * @param index
	 * @return
	 */
	private int rightChildIndex(int index){
		return index * 2 + 2;
	}

	/**
	 * 将index位置的值更新为e
	 * @param index
	 * @param e
	 */
	public void set(int index, E e){
		if (index > 0 || index >= data.length){
			throw new IllegalArgumentException("Index is illegal.");
		}
		data[index] = e;

	}

	/**
	 * 在以treeIndex为根的线段树中更新index的值为e
	 * @param treeIndex
	 * @param left
	 * @param right
	 * @param index
	 * @param e
	 */
	public void set(int treeIndex, int left, int right, int index, E e){
		if (left == right){
			tree[treeIndex] = e;
			return;
		}

		int middle = left + (right - left) / 2;
		// treeIndex的节点为[left...middle] 和[middle + 1 ... right]两部分
		int leftChildIndex = leftChildIndex(treeIndex);
		int rightChildIndex = rightChildIndex(treeIndex);
		if (index >= middle + 1){
			set(rightChildIndex, middle + 1, right, index, e);
		}else {
			set(leftChildIndex, left, middle, index, e);
		}
		tree[treeIndex] = merger.merge(tree[leftChildIndex], tree[rightChildIndex]);
	}

	@Override
	public String toString() {
		StringBuilder res = new StringBuilder();
		res.append('[');
		for (int i = 0; i < tree.length; i++) {
			if (tree[i] != null){
				res.append(tree[i]);
			}else {
				res.append("null");
			}
			if (i != tree.length - 1){
				res.append(", ");
			}
		}
		res.append(']');
		return res.toString();
	}
}
