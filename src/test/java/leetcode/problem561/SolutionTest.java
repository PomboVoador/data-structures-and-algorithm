package leetcode.problem561;

import com.changxu.leetcode.problem561.Solution;
import org.junit.Test;

import java.util.Arrays;

/**
 * @version 1.0
 * @title: SolutionTest
 * @desc:
 * @package: leetcode.problem561
 * @author: chang.xu
 * @date: 2019/01/31 15:33
 */
public class SolutionTest {

	@Test
	public void arrayPairSumTest() {
		int[] nums = {1, 4, 3, 2, 5, 6};
		int result = new Solution().arrayPairSum(nums);
		System.out.println("result = " + result);
	}
}