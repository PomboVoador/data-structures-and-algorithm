package linkedlist;

import com.changxu.linkedlist.LinkedList;
import org.junit.Test;

/**
 * @version 1.0
 * @title: LinkedListTest
 * @desc: 链表测试类
 * @package: com.changxu.linkedlist
 * @author: chang.xu
 * @date: 2019/01/25 17:52
 */
public class LinkedListTest {

	@Test
	public void test(){
		LinkedList<Integer> linkedList = new LinkedList<Integer>();
		for (int i = 0; i < 5; i++) {
			linkedList.addFirst(i);
			System.out.println(linkedList.toString());
		}
		System.out.println(linkedList);

		linkedList.add(2, 266);
		System.out.println(linkedList);

		linkedList.remove(2);
		System.out.println(linkedList);

		linkedList.removeFirst();
		System.out.println(linkedList);

		linkedList.removeLast();
		System.out.println(linkedList);

		linkedList.removeElement(2);
		System.out.println(linkedList);
	}
}
