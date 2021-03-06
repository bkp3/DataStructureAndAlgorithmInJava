package Tree;

import java.util.*;

public class BinarySearchTree {

	private TreeNode root;

	private class TreeNode {
		private int data;
		private TreeNode left;
		private TreeNode right;

		public TreeNode(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	public void insert(int value) {
		root = insert(root, value);
	}

	public TreeNode insert(TreeNode root, int value) {
		if (root == null) {
			root = new TreeNode(value);
			return root;
		}
		if (value < root.data) {
			root.left = insert(root.left, value);
		} else {
			root.right = insert(root.right, value);
		}
		return root;
	}

	public void levelOrder(TreeNode root) {
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

	public TreeNode search(int value) {
		return search(root, value);
	}

	public TreeNode search(TreeNode root, int key) {
		if (root == null || root.data == key) {
			return root;
		}
		if (key < root.data) {
			return search(root.left, key);
		} else {
			return search(root.right, key);
		}
	}

	/*
	 * public boolean isBST(TreeNode node) { if (node == null) { return true; } if
	 * (node.left != null && node.left.data > node.data) { return false; } if
	 * (node.right != null && node.right.data < node.data) { return false; } if
	 * (!isBST(node.left) || !isBST(node.right)) { return false;
	 * 
	 * } return true; }
	 */

	public boolean isBSTUtils(TreeNode root, int min, int max) {
		if (root == null) {
			return true;
		}
		if (root.data < min || root.data > max) {
			return false;
		}
		return (isBSTUtils(root.left, min, root.data - 1) && isBSTUtils(root.right, root.data + 1, max));
	}

	boolean isBST(TreeNode root) {
		return isBSTUtils(root, Integer.MIN_VALUE, Integer.MAX_VALUE);

	}

	public static void main(String[] args) {
		BinarySearchTree obj = new BinarySearchTree();
		obj.insert(2);
		obj.insert(5);
		obj.insert(3);
		obj.insert(1);
		obj.insert(4);
		obj.levelOrder(obj.root);

		if (obj.search(3) != null) {
			System.out.println("Key is present.");
		} else {
			System.out.println("Key is not present.");
		}

		System.out.println(obj.isBST(obj.root));
	}

}
