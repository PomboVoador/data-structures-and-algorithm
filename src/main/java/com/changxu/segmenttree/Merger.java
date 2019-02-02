package com.changxu.segmenttree;

/**
 * @version 1.0
 * @title: Merger
 * @desc: 融合器
 * @package: com.changxu.segmenttree
 * @author: chang.xu
 * @date: 2019/01/30 17:24
 */
public interface Merger<E> {

	/**
	 * 合并操作
	 * @param a
	 * @param b
	 * @return
	 */
	E merge(E a, E b);
}
