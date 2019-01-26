package array;

import com.changxu.array.Array;
import org.junit.Test;

/**
 * @version 1.0
 * @title: ArrayListTest
 * @desc: 数组测试类
 * @package: array
 * @author: chang.xu
 * @date: 2019/01/26 21:14
 */
public class ArrayListTest {

	@Test
	public void test(){
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
