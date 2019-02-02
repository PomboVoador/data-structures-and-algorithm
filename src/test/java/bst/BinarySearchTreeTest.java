package bst;

import com.changxu.bst.BinarySearchTree;
import org.junit.Test;

/**
 * @version 1.0
 * @title: BinarySearchTreeTest
 * @desc: 二分搜索树测试类
 * @package: bst
 * @author: chang.xu
 * @date: 2019/01/28 22:44
 */
public class BinarySearchTreeTest {

	/**
	 * 测试方法
	 */
	@Test
	public void testMethod(){
		BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<Integer>();
		int[] nums = {5, 3, 6, 8, 4, 2};
		for(int num: nums){
			binarySearchTree.add(num);
		}

		System.out.println("----------------preOrder----------------");
		binarySearchTree.preOrder();

		System.out.println("----------------inOrder----------------");
		binarySearchTree.inOrder();

		System.out.println("----------------postOrder----------------");
		binarySearchTree.postOrder();

		System.out.println("----------------preOrderNR----------------");
		binarySearchTree.preOrderNR();

		System.out.println("----------------inOrderNR----------------");
		binarySearchTree.inOrderNR();

		System.out.println("----------------levelOrder----------------");
		binarySearchTree.levelOrder();

		System.out.println("----------------removeMax----------------");
		binarySearchTree.removeMax();
		System.out.println(binarySearchTree.toString());

		System.out.println("----------------removeMin----------------");
		binarySearchTree.removeMin();
		System.out.println(binarySearchTree.toString());

		System.out.println("----------------remove----------------");
		binarySearchTree.remove(6);
		System.out.println(binarySearchTree.toString());


	}
}
