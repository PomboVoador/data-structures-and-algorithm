package com.changxu.array;

/**
 * @version 1.0
 * @title: Array
 * @desc:   数组
 * @package: com.changxu.array
 * @author: chang.xu
 * @date: 2018/12/21 17:29
 */
public class Array<E> {

	private E[] data;
	private int size;

	/**
	 * 扩容率
	 */
	private static final int EXPANSION_RADIO = 2;

	/**
	 * 默认的容量
	 */
	private static final int DEFAULT_CAPACITY = 10;

	/**
	 * 构造函数,传入数组的容量capacity构造Array
	 * @param capacity
	 */
	public Array(int capacity){
		data = (E[])new Object[capacity];
		size = 0;
	}

	/**
	 * 无参数的构造函数,默认数组的容量capacity = 10
	 */
	public Array() {
		this(DEFAULT_CAPACITY);
	}

	public Array(E[] arr){
		data = (E[])new Object[arr.length];
		for (int i = 0; i < arr.length; i++) {
			data[i] = arr[i];
		}
		size = arr.length;
	}

	/**
	 * 获取数组的容量
	 * @return
	 */
	public int getCapacity(){
		return data.length;
	}

	/**
	 * 获取数组中的元素个数
	 * @return
	 */
	public int getSize(){
		return size;
	}

	/**
	 * 返回数组是否为空
	 * @return
	 */
	public boolean isEmpty(){
		return size == 0;
	}

	/**
	 * 向所有元素后添加一个新元素
	 * @param e
	 */
	public void addLast(E e){
/*
		if (size == data.length){
			throw new IllegalArgumentException("AddLast failed.Array is full");
		}
		data[size] = e;
*/
		add(size, e);
	}

	/**
	 * 在所有元素前添加一个新元素
	 * @param e
	 */
	public void addFirst(E e){
		add(0, e);
	}

	/**
	 * 在index索引的位置插入一个新元素
	 * @param index
	 * @param e
	 */
	public void add(int index, E e){
		if (index < 0 || index > size){
			throw new IllegalArgumentException("Add failed.Reqiure index >= 0 and index <= size ");
		}
/*
		if (size == data.length){
			throw new IllegalArgumentException("Add failed.Array is full");
		}
*/

		if (size == data.length){
			resize(EXPANSION_RADIO * data.length);
		}

		for (int i = size - 1; i >= index ; i--) {
			data[i + 1] = data[i];
		}
		data[index] = e;
		size ++;
	}

	/**
	 * 将数组空间的容量编程newCapacity
	 * @param newCapacity
	 */
	public void resize(int newCapacity){
		E[] newData = (E[]) new Object[newCapacity];
		for (int i = 0; i < size; i++) {
			newData[i] = data[i];
		}
		data = newData;
	}

	/**
	 * 获取index索引位置的元素
	 * @param index
	 * @return
	 */
	public E get(int index){
		if (index < 0 || index >= size){
			throw new IllegalArgumentException("Get failed.Index is illegal");
		}
		return data[index];
	}

	/**
	 * 获取数组最后一个元素
	 * @return
	 */
	public E getLast(){
		return get(size - 1);
	}

	/**
	 * 获取数组的第一个元素
	 * @return
	 */
	public E getFirst(){
		return get(0);
	}

	/**
	 * 修改index索引位置的元素为e
	 * @param index
	 * @param e
	 */
	public void set(int index, E e){
		if (index < 0 || index >= size){
			throw new IllegalArgumentException("Set failed.Index is illegal");
		}
		data[index] = e;
	}

	/**
	 * 查找数组中是否有元素e
	 * @param e
	 * @return
	 */
	public boolean contain(E e){
		for (int i = 0; i < size; i++) {
			if (data[i].equals(e)){
				return true;
			}
		}
		return false;
	}

	/**
	 * 查找数组中元素e所在的索引,如果不存在元素e,则返回-1
	 * @param e
	 * @return
	 */
	public int find(E e){
		for (int i = 0; i < size; i++) {
			if (data[i] == e){
				return i;
			}
		}
		return -1;
	}

	/**
	 * 从数组中删除index位置的元素,返回删除的元素
	 * @param index
	 * @return
	 */
	public E remove(int index){
		if (index < 0 || index >= size){
			throw new IllegalArgumentException("Remove failed.Index is illegal");
		}

		E returnElement = data[index];
		for (int i = index + 1; i < size; i++) {
			data[i - 1] = data[i];
		}
		size --;
		data[size] = null;

/*
		if (size == data.length / 2){
			resize(data.length / 2);
		}
*/
		//data.length == 1 时, resize(0) 是错误的,所以需要加上限制条件data.length / 2 != 0
		if (size == data.length / (EXPANSION_RADIO * EXPANSION_RADIO) && data.length / EXPANSION_RADIO != 0){
			resize(data.length / EXPANSION_RADIO);
		}
		return returnElement;
	}

	/**
	 * 从数组中删除第一个元素,返回删除的元素
	 * @return
	 */
	public E removeFirst(){
		return remove(0);
	}


	/**
	 * 从数组中删除最后一个元素,返回删除的元素
	 * @return
	 */
	public E removeLast(){
		return remove(size - 1);
	}

	/**
	 * 从数组中删除元素e
	 * @param e
	 */
	public void removeElement(E e){
		int index = find(e);
		if (index != -1){
			remove(index);
		}
	}

	@Override
	public String toString(){
		StringBuilder res = new StringBuilder();
		res.append(String.format("Array: size = %d, capacity = %d\n",size, data.length));
		res.append('[');
		for (int i = 0; i < size; i++) {
			res.append(data[i]);
			if (i != size - 1){
				res.append(",");
			}
		}
		res.append(']');
		return res.toString();
	}

	public void swap(int i, int j) {
		E temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}
}
