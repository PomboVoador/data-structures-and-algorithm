package com.changxu.setandmap;

/**
 * @version 1.0
 * @title: Map
 * @desc: map集合
 * @package: com.changxu.setandmap
 * @author: chang.xu
 * @date: 2019/01/29 16:37
 */
public interface Map<K, V> {

	/**
	 * 获取实际的元素数量
	 * @return
	 */
	int size();

	/**
	 * 判断是否为空
	 * @return
	 */
	boolean isEmpty();

	/**
	 * 通过key获取value值
	 * @param key
	 * @return
	 */
	V get(K key);

	/**
	 * 添加键值对
	 * @param key
	 * @param value
	 * @return  若key为空,则返回null; key非空时,则返回key之前对应的value值.
	 */
	V put(K key, V value);

	/**
	 * 返回key之前对应的value(若当前map不存在key,则返回null)
	 * @param key
	 * @return
	 */
	V remove(V key);

	/**
	 * 判断当前集合中是否包含key
	 * @param key
	 * @return
	 */
	boolean containsKey(K key);

	/**
	 * 更新value值
	 * @param key
	 * @param value
	 */
	void replace(K key, V value);


}
