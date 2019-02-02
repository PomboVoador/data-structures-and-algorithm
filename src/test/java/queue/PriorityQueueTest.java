package queue;

import com.changxu.queue.PriorityQueue;
import org.junit.Test;

import java.util.Random;

/**
 * @version 1.0
 * @title: PriorityQueueTest
 * @desc: 优先队列测试类
 * @package: queue
 * @author: chang.xu
 * @date: 2019/01/30 14:44
 */
public class PriorityQueueTest {

	@Test
	public void test(){
		int n = 6;
		Random random = new Random();

		int[] arr = {10, 8, 1, 11, 12, 5};


		PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
		for (int i = 0; i < 6; i++) {
			priorityQueue.enqueue(arr[i]);
		}

		System.out.println("------------------------");

		for (int i = 0; i < n; i++) {
			priorityQueue.dequeue();
		}

	}

}
