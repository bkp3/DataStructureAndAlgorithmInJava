package Tree;

import java.util.*;

public class PreOrderTraversal {
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

	public PreOrderTraversal() {

	}

	// Pre order traverasal (Recursive)
	public void preOrder(TreeNode root) {
		if (root == null) {
			return;
		}
		System.out.print(root.data + " ");
		preOrder(root.left);
		preOrder(root.right);
	}

	// Pre Order traversal (Iterative)
	public void preOrderIterative(TreeNode root) {
		if (root == null) {
			return;
		}
		Stack<TreeNode> st = new Stack();
		st.push(root);
		while (!st.empty()) {
			TreeNode temp = st.pop();
			System.out.print(temp.data + " ");
			if (temp.left != null) {
				st.push(temp.left);
			}
			if (temp.right != null) {
				st.push(temp.right);
			}
		}
		return;
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
		PreOrderTraversal obj = new PreOrderTraversal();
		obj.createBinaryTree();

		 obj.preOrder(obj.root);

	}

}
