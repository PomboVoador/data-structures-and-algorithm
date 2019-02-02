package trie;

import com.changxu.trie3.Trie;
import org.junit.Test;

/**
 * @version 1.0
 * @title: TestTrie
 * @desc: 测试字典树类
 * @package: trie
 * @author: chang.xu
 * @date: 2019/01/31 22:23
 */
public class TestTrie {


	@Test
	public void testAdd(){
		Trie trie = new Trie();
		trie.add("my");
		trie.add("name");
		trie.add("is");
		trie.add("jane");
		trie.add("japan");
		trie.add("i");
		trie.add("come");
		trie.add("from");
		trie.add("japan");
	}
}
