package heap;

import com.changxu.heap.MaxHeap;
import org.junit.Test;

import java.util.Random;

/**
 * @version 1.0
 * @title: MaxHeapTest
 * @desc: 最大堆测试类
 * @package: heap
 * @author: chang.xu
 * @date: 2019/01/30 13:49
 */
public class MaxHeapTest {


	@Test
	public void heapTest(){
		MaxHeap<Integer> maxHeap = new MaxHeap<Integer>();
		int n = 10;
		Random random = new Random();
		for (int i = 0; i < n; i++) {
			maxHeap.add(random.nextInt(Integer.MAX_VALUE));
		}
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = maxHeap.extractMax();
			System.out.println(arr[i]);
		}

		for (int i = 1; i < n; i++) {
			if (arr[i - 1] < arr[i]){
				throw new IllegalArgumentException("Error");
			}
		}
	}

	@Test
	public void testHeapMain(){
		int n = 1000000;

		Random random = new Random();
		Integer[] testData = new Integer[n];
		for (int i = 0; i < n; i++) {
			testData[i] = random.nextInt(Integer.MAX_VALUE);
		}

		double time1 = testHeapifyOrNo(testData, false);
		System.out.println("Without heapfiy:" + time1 + " s");

		double time2 = testHeapifyOrNo(testData, true);
		System.out.println("With heapfiy: " + time2 + " s");

	}

	private double testHeapifyOrNo(Integer[] testData, boolean isHeapify){
		long startTime = System.nanoTime();

		MaxHeap<Integer> maxHeap;
		if (isHeapify){
			maxHeap = new MaxHeap<Integer>(testData);
		}else {
			maxHeap = new MaxHeap<Integer>();
			for (int num : testData) {
				maxHeap.add(num);
			}
		}

		int[] arr = new int[testData.length];
		for (int i = 0; i < testData.length; i++) {
			arr[i] = maxHeap.extractMax();
		}

		for (int i = 1; i < testData.length; i++) {
			if (arr[i - 1] < arr[i]){
				throw new IllegalArgumentException("Error.");
			}
		}
		long endTime = System.nanoTime();
		System.out.println("Test MaxHeap completed.");
		return (endTime - startTime) / 1000000000.0;
	}

}
