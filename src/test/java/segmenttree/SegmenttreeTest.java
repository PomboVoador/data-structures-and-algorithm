package segmenttree;

import com.changxu.segmenttree.Merger;
import com.changxu.segmenttree.SegmentTree;
import org.junit.Assert;
import org.junit.Test;

/**
 * @version 1.0
 * @title: SegmenttreeTest
 * @desc: 线段树测试类
 * @package: segmenttree
 * @author: chang.xu
 * @date: 2019/01/31 16:35
 */
public class SegmenttreeTest {

	@Test
	public void test(){
		Integer[] arr = {1, 3, -1, 4, 0, -2};

		SegmentTree<Integer> segmentTree = new SegmentTree<Integer>(arr, new Merger<Integer>() {
			@Override
			public Integer merge(Integer a, Integer b) {
				return a + b;
			}
		});

		System.out.println(segmentTree.toString());
		Integer sum = segmentTree.query(0, 5);

		int[] arr1= {1, 2, 3, 4, 5};
		int[] arr2= {1, 2, 3, 4, 5};
		Assert.assertArrayEquals(arr1, arr2);
		System.out.println(sum);
	}
}
