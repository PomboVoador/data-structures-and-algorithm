package leetcode.problem211;

import com.changxu.leetcode.problem211.WordDictionary;
import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @version 1.0
 * @title: TestWordDictionary
 * @desc:
 * @package: leetcode.problem211
 * @author: chang.xu
 * @date: 2019/02/01 16:37
 */
public class TestWordDictionary extends TestCase {

	private WordDictionary wordDictionary;


	@Override
	public void setUp() throws Exception {
		wordDictionary = new WordDictionary();
	}

	public void testExample() {
		wordDictionary.addWord("bad");
		wordDictionary.addWord("dad");
		wordDictionary.addWord("mad");

		boolean search1 = wordDictionary.search("pad");
		Assert.assertEquals(search1, false);

		boolean search2 = wordDictionary.search("bad");
		Assert.assertEquals(search2, true);

		boolean search3 = wordDictionary.search(".ad");
		Assert.assertEquals(search3, true);

		boolean search4 = wordDictionary.search("b..");
		Assert.assertEquals(search4, true);
	}
}


/*
	addWord("bad")
	addWord("dad")
	addWord("mad")
	search("pad") -> false
	search("bad") -> true
	search(".ad") -> true
	search("b..") -> true
*/
