package com.changxu.setandmap;

import com.changxu.bst.BinarySearchTree;

/**
 * @version 1.0
 * @title: BinarySearchTreeSet
 * @desc: 基于二分搜索树的set
 * @package: com.changxu.setandmap
 * @author: chang.xu
 * @date: 2019/01/29 15:29
 */
public class BinarySearchTreeSet<E extends Comparable<E>> implements Set<E> {

	/**
	 * 存储集合元素的二分搜索树
	 */
	private BinarySearchTree<E> binarySearchTree;

	public BinarySearchTreeSet() {
		this.binarySearchTree = new BinarySearchTree<E>();
	}

	/**
	 * 获取集合的大小
	 * @return
	 */
	@Override
	public int size() {
		return binarySearchTree.size();
	}

	/**
	 * 返回集合是否为空
	 * @return
	 */
	@Override
	public boolean isEmpty() {
		return binarySearchTree.isEmpty();
	}

	/**
	 * 判断集合是否待检测的元素o
	 * @param o 在集合中待检测是否存在的元素
	 * @return
	 */
	@Override
	public boolean contains(Object o) {
		return binarySearchTree.contains((E)o);
	}

	/**
	 * 添加元素至集合中
	 * @param o
	 * @return
	 */
	@Override
	public void add(Object o) {
		binarySearchTree.add((E)o);
	}

	/**
	 * 从集合中移除元素
	 * @param o 集合中待删除的元素(如果存在)
	 * @return
	 */
	@Override
	public void remove(Object o) {
		binarySearchTree.remove((E)o);
	}
}
