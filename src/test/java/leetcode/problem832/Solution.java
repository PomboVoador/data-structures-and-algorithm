package leetcode.problem832;

/**
 * @version 1.0
 * @title: SolutionTest
 * @desc:
 * @package: leetcode.problem832
 * @author: chang.xu
 * @date: 2019/01/31 15:08
 */
public class Solution {
	public int[][] flipAndInvertImage(int[][] A) {
		//To flip an image horizontally means that each row of the image is reversed.
		// For example, flipping [1, 1, 0] horizontally results in [0, 1, 1].
		//To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0.
		// For example, inverting [0, 1, 1] results in [1, 0, 0].
		int C = A[0].length;
		for (int[] row: A){
			for (int i = 0; i < (C + 1) / 2; i++) {
				int tmp = row[i] ^ 1;
				row[i] = row[C - 1 -i] ^ 1;
				row[C - 1 -i] = tmp;
			}
		}
		return A;
	}
}
