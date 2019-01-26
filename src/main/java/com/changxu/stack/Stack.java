package com.changxu.stack;

/**
 * @version 1.0
 * @title: Stack
 * @desc: 栈接口
 * @package: com.changxu.stack
 * @author: chang.xu
 * @date: 2019/01/25 13:46
 */
public interface Stack<E> {

	/**
	 * 获取栈的大小
	 * @return
	 */
	int getSize();

	/**
	 * 判断栈是否为空
	 * @return
	 */
	boolean isEmpty();

	/**
	 * 将元素e放入栈中
	 * @param e
	 */
	void push(E e);

	/**
	 * 删除堆栈顶部的对象,并将该对象作为该函数的值返回。
	 * @return
	 */
	E pop();

	/**
	 * 查看当前堆栈顶部的对象,但不将其从堆栈中删除
	 * @return
	 */
	E peek();


}
