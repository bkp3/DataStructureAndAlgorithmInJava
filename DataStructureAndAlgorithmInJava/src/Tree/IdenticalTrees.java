package Tree;

import java.util.*;
/*
output:-
Two trees are identical?? :- true
 

*/

public class IdenticalTrees {

	public static class TreeNode {
		private TreeNode left;
		private TreeNode right;
		private int data;

		public TreeNode(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	public IdenticalTrees() {

	}

	// iterative method
	public boolean areIdentical(TreeNode root1, TreeNode root2) {
		if (root1 == null && root2 == null) {
			return true;
		}
		if (root1 == null || root2 == null) {
			return false;
		}

		Queue<TreeNode> q1 = new LinkedList<>();
		Queue<TreeNode> q2 = new LinkedList<>();

		q1.offer(root1);
		q2.offer(root2);

		while (!q1.isEmpty() && !q2.isEmpty()) {
			TreeNode temp1 = q1.poll();
			TreeNode temp2 = q2.poll();

			if (temp1.data != temp2.data) {
				return false;
			}

			if (temp1.left != null && temp2.left != null) {
				q1.offer(temp1.left);
				q2.offer(temp2.left);
			} else if (temp1.left != null || temp2.left != null) {
				return false;
			}

			if (temp1.right != null && temp2.right != null) {
				q1.offer(temp1.right);
				q2.offer(temp2.right);
			} else if (temp1.right != null || temp2.right != null) {
				return false;
			}
		}
		return true;
	}

	// recursive method
	public boolean areIdenticalRec(TreeNode root1, TreeNode root2) {

		// if both empty
		if (root1 == null && root2 == null) {
			return true;
		}

		// if both non-empty
		if (root1 != null && root2 != null) {
			return (root1.data == root2.data && areIdenticalRec(root1.left, root2.left)
					&& areIdenticalRec(root1.right, root2.right));
		}

		// one empty, one not
		return false;
	}

	public static void main(String[] args) {
		IdenticalTrees obj = new IdenticalTrees();

		// creation of binary tree first
		TreeNode first1 = new TreeNode(1);
		TreeNode second1 = new TreeNode(2);
		TreeNode third1 = new TreeNode(3);
		TreeNode fourth1 = new TreeNode(4);
		TreeNode fifth1 = new TreeNode(5);

		TreeNode root1 = first1;
		first1.left = second1;
		first1.right = third1;

		second1.left = fourth1;
		second1.right = fifth1;

		// creation of binary tree second
		TreeNode first2 = new TreeNode(1);
		TreeNode second2 = new TreeNode(2);
		TreeNode third2 = new TreeNode(3);
		TreeNode fourth2 = new TreeNode(4);
		TreeNode fifth2 = new TreeNode(5);

		TreeNode root2 = first2;
		first2.left = second2;
		first2.right = third2;

		second2.left = fourth2;
		second2.right = fifth2;

		boolean flag = obj.areIdenticalRec(root1, root2);
		System.out.println("Two trees are identical?? :- " + flag);

	}

}
