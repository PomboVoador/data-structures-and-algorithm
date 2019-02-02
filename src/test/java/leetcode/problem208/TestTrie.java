package leetcode.problem208;

import com.changxu.leetcode.problem208.Trie;
import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @version 1.0
 * @title: TestTrie
 * @desc: trie测试类
 * @package: leetcode.problem208
 * @author: chang.xu
 * @date: 2019/02/01 10:35
 */
public class TestTrie extends TestCase {


	public void test(){
		Trie trie = new Trie();

		trie.insert("apple");
		boolean serachApple = trie.search("apple");// returns true

		Assert.assertEquals(serachApple, true);

		boolean searchApp = trie.search("app");// returns false
		boolean startWithApp = trie.startsWith("app");// returns true

		Assert.assertEquals(startWithApp, true);

		trie.insert("app");
		boolean searchApp2 = trie.search("app");// returns true

		Assert.assertEquals(searchApp2, true);
	}
}
