package com.changxu.leetcode.problem732;

/**
 * @version 1.0
 * @title: MyCalendarThree
 * @desc: 我的日程安排表 III
 * @package: com.changxu.leetcode.problem732
 * @author: chang.xu
 * @date: 2019/01/31 17:21
 */
class MyCalendarThree {


	public MyCalendarThree() {



	}

	public int book(int start, int end) {
		return 0;
	}
}



class SegmentTree {

	TreeNode root;

	public SegmentTree(int left, int right) {
		root = new TreeNode(left, right);
	}

	public void add(TreeNode root, TreeNode event, int val) {
		if (root == null) {
			return;
		}

	}



}


class TreeNode {

	int start, end;
	TreeNode left = null;
	TreeNode right = null;

	/**
	 * How much number is added to this interval(node)
	 */
	int booked = 0;

	/**
	 * The maximum number is this interval(node)
	 */
	int savedres = 0;

	public TreeNode(int start, int end) {
		this.start = start;
		this.end = end;
	}

	public boolean inside(TreeNode b) {
		if (b.start <= start && end <= b.end){
			return true;
		}
		return false;
	}

	public boolean intersect(TreeNode b) {
		if (inside(b) || end <= b.start || b.end <= start){
			return false;
		}
		return true;
	}

}


/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(start,end);
 */
