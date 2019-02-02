package com.changxu.setandmap;

import java.util.Collection;

/**
 * @version 1.0
 * @title: Set
 * @desc: set
 * @package: com.changxu.setandmap
 * @author: chang.xu
 * @date: 2019/01/29 13:57
 */
public interface Set<E> {

	/**
	 * 返回集合的大小
	 * @return
	 */
	int size();

	/**
	 * 判断集合是否为空
	 * @return
	 */
	boolean isEmpty();

	/**
	 * 查看是否包含指定元素
	 * @param o 在集合中待检测是否存在的元素
	 * @return
	 */
	boolean contains(Object o);

	/**
	 * 添加对象至集合中
	 * @param o
	 * @return
	 */
	void add(Object o);

	/**
	 * 移除存在于集合中的指定元素
	 * @param o 集合中待删除的元素(如果存在)
	 * @return
	 */
	void remove(Object o);
}
