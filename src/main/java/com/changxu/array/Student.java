package com.changxu.array;

/**
 * @version 1.0
 * @title: Student
 * @desc: 学生类
 * @package: com.changxu.array
 * @author: chang.xu@vilang.com
 * @date: 2018/12/21 18:54
 */
public class Student {

	private String name;
	private int score;

	public Student(String name, int score) {
		this.name = name;
		this.score = score;
	}


	@Override
	public String toString() {
		return "Student{" +
				"name='" + name + '\'' +
				", score=" + score +
				'}';
	}


	public static void main(String[] args) {
		Array<Student> arr = new Array<Student>(20);

		arr.addLast(new Student("张三", 100));
		arr.addLast(new Student("李四", 100));
		arr.addLast(new Student("王二", 100));

		System.out.println(arr);




	}
}
