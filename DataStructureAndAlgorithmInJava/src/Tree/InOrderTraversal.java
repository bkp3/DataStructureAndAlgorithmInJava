package Tree;

import java.util.*;

public class InOrderTraversal {
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

	public InOrderTraversal() {

	}

	// In Order Traversal (Recursive)
	public void inOrder(TreeNode root) {
		if (root == null) {
			return;
		}
		inOrder(root.left);
		System.out.print(root.data + " ");
		inOrder(root.right);
	}

	// In Order Traversal (Iterative)
	public void inOrderIterative(TreeNode root) {
		if (root == null) {
			return;
		}
		Stack<TreeNode> st = new Stack<>();
		TreeNode temp = root;
		while (!st.isEmpty() || temp != null) {
			if (temp != null) {
				st.push(temp);
				temp = temp.left;
			} else {
				temp = st.pop();
				System.out.print(temp.data + " ");
				temp = temp.right;
			}
		}
	}

	public void createBinaryTree() {
		TreeNode first = new TreeNode(1);
		TreeNode second = new TreeNode(2);
		TreeNode third = new TreeNode(3);
		TreeNode fourth = new TreeNode(4);
		TreeNode fifth = new TreeNode(5);

		root = first;
		first.left = second;
		first.right = third;

		second.left = fourth;
		second.right = fifth;
	}

	public static void main(String[] args) {
		InOrderTraversal obj = new InOrderTraversal();
		obj.createBinaryTree();

		obj.inOrderIterative(obj.root);

	}

}
