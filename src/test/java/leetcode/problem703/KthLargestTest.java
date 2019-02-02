package leetcode.problem703;

import com.changxu.leetcode.problem703.KthLargest;
import org.junit.Test;

import java.util.PriorityQueue;

/**
 * Design a class find the kth largest element in a stream,Note that it is the kth largest element
 * in the sorted order,not the kth distinct element.
 *
 * Your KthLargestTest class will have a constructor which accepts an integer k
 * and an integer array nums,which contains initail elements from the stream,
 * For each call to the method KthLargestTest.add, return the element representing
 * the kth largest element in the stream.
 *
 * @version 1.0
 * @title: KthLargestTest
 * @desc: 703Test
 * @package: leetcode
 * @author: chang.xu
 * @date: 2019/01/30 15:44
 */
public class KthLargestTest {


	@Test
	public void test(){
		int k = 3;
		int[] arr = {10, 3, 4, 2, 5, 7, 8};
		KthLargest kthLargest = new KthLargest(6, arr);
		int add;

		add = kthLargest.add(2);

		System.out.println(add);

		add = kthLargest.add(9);




		System.out.println(add);




	}



}