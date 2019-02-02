package com.changxu.bst;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @version 1.0
 * @title: BinarySearchTree
 * @desc: 二分搜索树
 * @package: com.changxu.bst
 * @author: chang.xu
 * @date: 2019/01/26 21:20
 */
public class BinarySearchTree<E extends Comparable<E>> {

	private class Node{
		private E e;
		private Node left;
		private Node right;

		public Node(E e) {
			this.e = e;
			left = null;
			right = null;
		}
	}

	/**
	 * 根节点
	 */
	private Node root;

	/**
	 * 数组容量的大小
	 */
	private int size;

	public BinarySearchTree() {
		root = null;
		size = 0;
	}

	/**
	 * 返回当前二分搜索树中的元素个数
	 * @return
	 */
	public int size(){
		return size;
	}

	/**
	 * 判断二分搜索树容器是否为空
	 * @return
	 */
	public boolean isEmpty(){
		return size == 0;
	}

	/**
	 * 向二分搜索树中添加新的元素
	 * @param e
	 */
	public void add(E e){
		if (root == null){
			root = new Node(e);
			size ++;
		}else {
			add(root, e);
		}
	}

	/**
	 * 向以node为根的二分搜索树中插入元素e,递归算法
	 * 返回插入新节点后二分搜索树的根
	 * @param node
	 * @param e
	 * @return
	 */
	private Node add(Node node, E e) {
		if (node == null){
			size ++;
			return new Node(e);
		}
		if (e.compareTo(node.e) < 0){
			node.left = add(node.left, e);
		}else if (e.compareTo(node.e) > 0){
			node.right = add(node.right, e);
		}
		return node;
	}

	/**
	 * 查看二分搜索书中是否包含元素e
	 * @param e
	 * @return
	 */
	public boolean contains(E e){
		return contains(root, e);
	}

	/**
	 * 查看以node为根节点的二分搜索树中是否包含元素e
	 * @param node
	 * @param e
	 * @return
	 */
	private boolean contains(Node node, E e) {
		if (node == null){
			return false;
		}
		if (e.compareTo(node.e) == 0){
			return true;
		}else if (e.compareTo(node.e) < 0){
			return contains(node.left, e);
		}else {
			return contains(node.right, e);
		}
	}

	/**
	 * 二分搜索树的前序遍历
	 */
	public void preOrder(){
		preOrder(root);
	}

	/**
	 * 前序遍历以node为根的二分搜索树,递归算法
	 * @param node
	 */
	private void preOrder(Node node) {
		if (node == null){
			return;
		}
		System.out.println(node.e);
		preOrder(node.left);
		preOrder(node.right);
	}

	/**
	 * 二分搜索树的非递归前序遍历
	 */
	public void preOrderNR(){
		if (root == null){
			return;
		}
		Stack<Node> stack = new Stack<Node>();
		stack.push(root);
		while (!stack.isEmpty()){
			Node pop = stack.pop();
			System.out.println(pop.e);
			if (pop.right != null){
				stack.push(pop.right);
			}
			if (pop.left != null){
				stack.push(pop.left);
			}
		}
	}

	/**
	 * 二分搜索树的中序遍历
	 */
	public void inOrder(){
		inOrder(root);
	}

	/**
	 * 前序遍历以node为根的二分搜索树,递归算法
	 * @param node
	 */
	private void inOrder(Node node) {
		if (node == null){
			return;
		}
		inOrder(node.left);
		System.out.println(node.e);
		inOrder(node.right);
	}

	/**
	 * 二分搜索树的非递归中序遍历
	 */
	public void inOrderNR(){
		if (root == null){
			return;
		}
		Stack<Node> stack = new Stack<Node>();
		stack.push(root);
		while (!stack.isEmpty()){
			Node pop = stack.pop();

			if (pop.right != null){
				stack.push(pop.right);
			}

			System.out.println(pop.e);

			if (pop.left != null){
				stack.push(pop.left);
			}
		}
	}

	/**
	 * 二分搜索树的后续遍历
	 */
	public void postOrder(){
		postOrder(root);
	}

	/**
	 * 后续遍历以node为根的二分搜索树,递归算法
	 * @param node
	 */
	private void postOrder(Node node) {
		if (node == null){
			return;
		}
		postOrder(node.left);
		postOrder(node.right);
		System.out.println(node.e);
	}

	/**
	 * 二分搜索树的层序遍历
	 */
	public void levelOrder(){
		if (root == null){
			return;
		}

		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		while (!queue.isEmpty()){
			Node cur = queue.remove();
			if (cur.left != null){
				queue.add(cur.left);
			}

			System.out.println(cur.e);
			if (cur.right != null){
				queue.add(cur.right);
			}
		}
	}

	/**
	 * 寻找二分搜索树的最小元素
	 * @return
	 */
	public E mininum(){
		if (size == 0){
			throw new IllegalArgumentException("Binary Serach Tree is empty.");
		}
		return mininum(root).e;
	}

	/**
	 * 返回以node为根的二分搜索树中最小值所在的节点
	 * @param node
	 * @return
	 */
	private Node mininum(Node node) {
		if (node.left == null){
			return node;
		}
		return mininum(node.left);
	}

	/**
	 * 寻找二分搜索树的最大元素
	 * @return
	 */
	public E maxinum(){
		if (size == 0){
			throw new IllegalArgumentException("Bianry Serach Tree is empty.");
		}
		return maxinum(root).e;
	}

	/**
	 * 返回以node为根的二分搜索树的最大值所在的节点
	 * @param node
	 * @return
	 */
	private Node maxinum(Node node) {
		if (node.right == null){
			return node;
		}
		return maxinum(node.right);
	}

	/**
	 * 从二分搜索树中删除最小值所在的节点,并返回最小值
	 * @return
	 */
	public E removeMin(){
		E ret = mininum();
		removeMin(root);
		return ret;
	}

	/**
	 * 删除掉以node为根的二分搜索树中的最小节点
	 * @param node
	 * @return
	 */
	private Node removeMin(Node node) {
		if (node.left == null){
			Node rightNode = node.right;
			node.right = null;
			size --;
			return rightNode;
		}
		node.left = removeMin(node.left);
		return node;
	}

	/**
	 * 从二分搜索树中删除最大值所在节点
	 * @return
	 */
	public E removeMax(){
		E ret = maxinum();
		root = removeMax(root);
		return ret;
	}

	/**
	 * 删除掉以node为根的二分搜索树的最大节点
	 * 返回删除节点后新的二分搜
	 * 索树的根
	 * @param node
	 * @return
	 */
	private Node removeMax(Node node){
		if (node.right == null){
			Node leftNode = node.left;
			node.left = null;
			size --;
			return leftNode;
		}
		node.right = removeMax(node.right);
		return node;
	}

	/**
	 * 从二分搜索树中删除元素为e的节点
	 * @param e
	 */
	public void remove(E e){
		remove(root, e);
	}

	/**
	 * 删除掉以node为根的二分搜索树中值为e的节点,递归算法
	 * 返回删除节点后新的二分搜索树的根
	 * @param node
	 * @param e
	 * @return
	 */
	private Node remove(Node node, E e){
		if (node == null){
			return null;
		}

		if (e.compareTo(node.e) < 0){
			node.left = remove(node.left, e);
			return node;
		}else if (e.compareTo(node.e) > 0){
			node.right = remove(node.right, e);
			return node;
		}else {
			//e.compareTo(node.e) == 0;
			//待删除元素左子树为空的情况
			if (node.left == null){
				Node rightNode = node.right;
				node.right = null;
				size --;
				return rightNode;
			}
			//待删除元素右子树为空的情况
			if (node.right == null){
				Node leftNode = node.left;
				node.left = null;
				size --;
				return leftNode;
			}
			//待删除元素左右子树均不为空的情况

			//找到比待删除节点大的最小节点,即待删除节点右子树的最小节点
			Node successor = mininum(node.right);
			successor.right = removeMin(node.right);
			successor.left = node.left;

			node.left = node.right = null;
			return successor;
		}
	}


	@Override
	public String toString() {
		StringBuilder res = new StringBuilder();
		generateBSTString(root, 0, res);
		return res.toString();
	}

	/**
	 * 生成以node为根节点,深度为depth的描述二叉树的字符串
	 * @param node 节点
	 * @param depth 深度
	 * @param res 结果
	 */
	private void generateBSTString(Node node, int depth, StringBuilder res){
		if (node == null){
			res.append(generateDepthString(depth) + "null\n");
			return;
		}
		res.append(generateDepthString(depth) + node.e + "\n");
		generateBSTString(node.left, depth + 1, res);
		generateBSTString(node.right, depth + 1, res);
	}

	/**
	 * @param depth 深度
	 * @return
	 */
	private String generateDepthString(int depth){
		StringBuilder res = new StringBuilder();
		for (int i = 0; i < depth; i++) {
			res.append("--");
		}
		return res.toString();
	}

}
