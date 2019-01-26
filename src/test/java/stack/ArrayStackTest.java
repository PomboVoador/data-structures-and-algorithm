package stack;

import com.changxu.stack.ArrayStack;
import com.changxu.stack.Stack;
import org.junit.Test;

/**
 * @version 1.0
 * @title: ArrayStackTest
 * @desc: 数组栈测试类
 * @package: com.changxu.stack
 * @author: chang.xu
 * @date: 2019/01/25 17:44
 */
public class ArrayStackTest {

	@Test
	public void test(){
		Stack<Integer> stack = new ArrayStack<Integer>();
		for (int i = 0; i < 5; i++) {
			stack.push(i);
		}
		stack.pop();

		System.out.println(stack);
	}
}
