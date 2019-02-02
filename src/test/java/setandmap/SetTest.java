package setandmap;

import com.changxu.bst.BinarySearchTree;
import com.changxu.linkedlist.LinkedList;
import com.changxu.setandmap.BinarySearchTreeSet;
import com.changxu.setandmap.LinkedListSet;
import com.changxu.setandmap.Set;
import org.junit.Test;

import java.util.ArrayList;

/**
 * @version 1.0
 * @title: SetTest
 * @desc: 集合测试类
 * @package: setandmap
 * @author: chang.xu
 * @date: 2019/01/29 14:40
 */
public class SetTest {

	/**
	 * 链表集合测试
	 */
	@Test
	public void linkedListSetTest(){
		LinkedListSet<Integer> set = new LinkedListSet<Integer>();
		for (int i = 0; i < 10; i++) {
			set.add(i);
		}
		System.out.println(set.size());
	}


	/**
	 * 二叉树集合测试
	 */
	@Test
	public void binarySearchTreeTest(){
		BinarySearchTree<Integer> set = new BinarySearchTree<Integer>();
		for (int i = 0; i < 10; i++) {
			set.add(i);
		}
		System.out.println(set.size());
	}

	@Test
	public void novelTest(){

		System.out.println("Pride and Prejudice");

		ArrayList<String> words1 = new ArrayList<String>();
		if (FileOperation.readFile("pride-and-prejudice.txt", words1)){
			System.out.println("Total words: " + words1.size());

			BinarySearchTreeSet<String> set1 = new BinarySearchTreeSet<String>();
			for (String word: words1){
				set1.add(word);
			}
			System.out.println("Total different words： " + set1.size());
		}

		System.out.println("\n--------------------------------------\n");

		System.out.println("A-Tale-of-Two-Cities");

		ArrayList<String> words2 = new ArrayList<String>();
		if (FileOperation.readFile("a-tale-of-two-cities.txt", words2)){
			System.out.println("Total words: " + words2.size());

			BinarySearchTreeSet<String> set2 = new BinarySearchTreeSet<String>();
			for (String word: words2){
				set2.add(word);
			}
			System.out.println("Total different words： " + set2.size());
		}


	}

	@Test
	public void performanceTest(){
		String filename = "pride-and-prejudice.txt";
		filename = "a-tale-of-two-cities.txt";

		Set<String> set;
		set = new BinarySearchTreeSet<String>();
		double time1 = testSet(set, filename);
		System.out.println("BinarySearchTreeSet：" + time1 + " s");

		System.out.println("\n--------------------------------------\n");

		set = new LinkedListSet<String>();
		double time2 = testSet(set, filename);
		System.out.println("LinkedListSet: " + time2 + " s");

	}

	/**
	 *
	 * @param set 待测试的集合
	 * @param fileName 需要测试的文件名
	 * @return
	 */
	private double testSet(Set<String> set, String fileName){
		long startTime = System.nanoTime();
		ArrayList<String> words = new ArrayList<String>();
		if (FileOperation.readFile(fileName, words)){
			System.out.println("Total words: " + words.size());

			for (String word: words){
				set.add(word);
			}
			System.out.println("Total different words: " + set.size());
		}
		long endTime = System.nanoTime();

		return (endTime - startTime) / 1000000000.0;
	}





}
