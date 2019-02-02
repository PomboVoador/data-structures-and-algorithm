package leetcode.problem677;

import com.changxu.leetcode.problem677.MapSum;
import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @version 1.0
 * @title: TestMapSum
 * @desc:
 * @package: leetcode.problem677
 * @author: chang.xu
 * @date: 2019/02/01 17:37
 */
public class TestMapSum extends TestCase {

	private MapSum mapSum;


	@Override
	public void setUp() throws Exception {
		mapSum = new MapSum();
	}


	public void testMapSum() {
		mapSum.insert("apple", 3);

		int sum = mapSum.sum("ap");
		Assert.assertEquals(sum, 3);

		mapSum.insert("app", 2);

		int ap2 = mapSum.sum("ap");
		Assert.assertEquals(ap2, 5);


	}

	@Override
	public void tearDown() throws Exception {

	}


}
