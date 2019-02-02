package leetcode.problem641;


import com.changxu.leetcode.problem641.MyCircularDeque;
import org.junit.Test;

/**
 * @version 1.0
 * @title: MyCircularDequeTest
 * @desc: 双端队列
 * @package: com.changxu.leetcode.problem641
 * @author: chang.xu
 * @date: 2019/01/31 9:36
 */
public class MyCircularDequeTest<E> {


	@Test
	public void test(){
		MyCircularDeque obj = new MyCircularDeque(10);
		boolean param_1 = obj.insertFront(1);
		boolean param_2 = obj.insertLast(10);
		boolean param_3 = obj.deleteFront();
		boolean param_4 = obj.deleteLast();
		int param_5 = obj.getFront();
		int param_6 = obj.getRear();
		boolean param_7 = obj.isEmpty();
		boolean param_8 = obj.isFull();
	}

}

/**
 * Your MyCircularDequeTest object will be instantiated and called as such:
 * MyCircularDequeTest obj = new MyCircularDequeTest(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */