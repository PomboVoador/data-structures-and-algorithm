package com.changxu.setandmap;


import com.changxu.linkedlist.LinkedList;

/**
 * @version 1.0
 * @title: LinkedListSet
 * @desc: 链表集合
 * @package: com.changxu.setandmap
 * @author: chang.xu
 * @date: 2019/01/29 13:59
 */
public class LinkedListSet<E> implements Set<E> {

	private LinkedList<E> list;

	public LinkedListSet() {
		this.list = new LinkedList<E>();
	}

	@Override
	public int size() {
		return list.getSize();
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public boolean contains(Object o) {
		return list.contains((E)o);
	}

	@Override
	public void add(Object o) {
		if (!contains((E)o)){
			list.addFirst((E)o);
		}
	}

	@Override
	public void remove(Object o) {
		if (contains(o)){
			list.removeElement((E)o);
		}
	}
}
