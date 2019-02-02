package com.changxu.leetcode.problem561;

import java.util.Arrays;

/**
 * @version 1.0
 * @title: Solution
 * @desc:
 * @package: leetcode.problem561
 * @author: chang.xu
 * @date: 2019/01/31 15:33
 */
public class Solution {
	public int arrayPairSum(int[] nums) {
		Arrays.sort(nums);
		int sum = 0;
		for (int i = 0; i < nums.length; i= i + 2) {
			sum = sum + nums[i];
		}
		return sum;
	}
}