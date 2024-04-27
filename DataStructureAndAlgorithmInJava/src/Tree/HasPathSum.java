package Tree;

import java.util.*;

public class HasPathSum {
	private TreeNode root;

	private class TreeNode {
		private TreeNode left;
		private TreeNode right;
		private int data;

		public TreeNode(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	public void createBinaryTree() {
		TreeNode first = new TreeNode(1);
		TreeNode second = new TreeNode(2);
		TreeNode third = new TreeNode(3);
		TreeNode fourth = new TreeNode(4);
		TreeNode fifth = new TreeNode(5);
		TreeNode sixth = new TreeNode(6);

		root = first;
		first.left = second;
		first.right = third;

		second.left = fourth;
		second.right = fifth;
		fifth.left = sixth;
	}

	boolean hasPathSum(TreeNode root, int sum) {
		if (root == null) {
			return false;
		}
		boolean ans = false;
		int subSum = sum - root.data;
		if (subSum == 0 && root.left == null && root.right == null) {
			return ans = true;
		}
		if (root.left != null) {
			ans = ans || hasPathSum(root.left, subSum);
		}
		if (root.right != null) {
			ans = ans || hasPathSum(root.right, subSum);
		}
		return ans;
	}

	// Level order traversal
	public void levelOrder(TreeNode root) {
		if (root == null) {
			return;
		}
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		while (!q.isEmpty()) {
			TreeNode temp = q.poll();
			System.out.print(temp.data + " ");

			if (temp.left != null) {
				q.offer(temp.left);
			}
			if (temp.right != null) {
				q.offer(temp.right);
			}
		}
	}

	public static void main(String[] args) {
		HasPathSum obj = new HasPathSum();
		obj.createBinaryTree();
		obj.levelOrder(obj.root);
		System.out.println(obj.hasPathSum(obj.root, 6));

	}

}
