package queue;

import com.changxu.queue.LinkedListQueue;
import com.changxu.queue.Queue;
import org.junit.Test;

/**
 * @version 1.0
 * @title: LinkedListQueueTest
 * @desc: 链表队列测试类
 * @package: queue
 * @author: chang.xu
 * @date: 2019/01/26 10:27
 */
public class LinkedListQueueTest {
	
	@Test
	public void test(){
		Queue queue = new LinkedListQueue();
		for (int i = 0; i < 10; i++) {
			queue.enqueue(i);
			System.out.println(queue);
			if (i % 3 == 2){
				queue.dequeue();
				System.out.println(queue);
			}

		}

		
	}
}
