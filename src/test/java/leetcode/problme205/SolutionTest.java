package leetcode.problme205;

import com.changxu.leetcode.problem215.Solution;
import org.junit.Test;

import java.util.Random;

/**
 * @version 1.0
 * @title: SolutionTest
 * @desc:
 * @package: leetcode.problme205
 * @author: chang.xu
 * @date: 2019/01/30 16:50
 */
public class SolutionTest {

	@Test
	public void test(){
		Solution solution = new Solution();
		int n = 10;

		int[] arr = new int[n];

		Random random = new Random();

		for (int i = 0; i < n; i++) {
			arr[i] = random.nextInt(Integer.MAX_VALUE);
			System.out.println(arr[i]);
		}

		int k = 10;
		int kthLargest = solution.findKthLargest(arr, k);
		System.out.println("kthLargest: " + kthLargest);
	}
}
