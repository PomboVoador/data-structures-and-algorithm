package com.changxu.array;

/**
 * @version 1.0
 * @title: Main
 * @desc:
 * @package: com.changxu.array
 * @author: chang.xu@vilang.com
 * @date: 2018/12/21 18:46
 */
public class Main {


	public static void main(String[] args) {

		Array<Integer> arr = new Array<Integer>(20);
		for (int i = 0; i < 10; i++) {
			arr.addLast(i);
		}
		System.out.println(arr);

		arr.add(1, 100);
		System.out.println(arr);

		arr.addFirst(-1);
		System.out.println(arr);

		arr.remove(2);
		System.out.println(arr);
		System.out.println(arr);

		arr.removeElement(4);
		System.out.println(arr);

		arr.removeFirst();
		System.out.println(arr);

		for (int i = 0; i < 4; i++) {
			arr.removeFirst();
			System.out.println(arr);
		}
	}


}
