package queue;

import com.changxu.queue.ArrayQueue;
import com.changxu.queue.LinkedListQueue;
import com.changxu.queue.LoopQueue;
import com.changxu.queue.Queue;
import org.junit.Test;

import java.util.Random;

/**
 * @version 1.0
 * @title: QueueTest
 * @desc: 队列测试类
 * @package: queue
 * @author: chang.xu
 * @date: 2019/01/26 20:58
 */
public class QueueTest {

	@Test
	public void test(){
		int opCount = 100000;

		ArrayQueue<Integer> arrayQueue = new ArrayQueue<Integer>();

		double time1 = testStack(arrayQueue, opCount);
		System.out.println("ArrayQueue, time:" + time1 + " s");

		LoopQueue<Integer> loopQueue = new LoopQueue<Integer>();

		double time2 = testStack(loopQueue, opCount);
		System.out.println("LoopQueue time:" + time2 + " s");


		LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<Integer>();

		double time3 = testStack(linkedListQueue, opCount);
		System.out.println("LinkedListQueue time:" + time3 + " s");
		//其实这个时间比较复杂,因为linkedListStack中包含更多new的操作
	}


	/**
	 * 测试使用stack运行opCount个push和pop操作所需要的时间,单位：秒
	 */
	public double testStack(Queue<Integer> queue, int opCount){

		long startTime = System.nanoTime();

		Random random = new Random();
		for (int i = 0; i < opCount; i++) {
			queue.enqueue(random.nextInt());
		}
		for (int i = 0; i < opCount; i++) {
			queue.dequeue();
		}

		long endTime = System.nanoTime();

		return (endTime - startTime) / 1000000000.0;
	}

}
