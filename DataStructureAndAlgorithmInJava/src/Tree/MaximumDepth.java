package Tree;

import java.util.LinkedList;
import java.util.Queue;

//4
public class MaximumDepth {

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

	public int maxDepth(TreeNode root) {
		int count = 0;
		if (root == null) {
			return 0;
		}
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		while (q.size() > 0) {
			int size = q.size();
			while (size-- > 0) {
				TreeNode temp = q.remove();
				if (temp.left != null) {
					q.add(temp.left);
				}
				if (temp.right != null) {
					q.add(temp.right);
				}
			}
			count++;
		}
		return count;

	}

	public static void main(String[] args) {
		MaximumDepth obj = new MaximumDepth();
		obj.createBinaryTree();
		System.out.println(obj.maxDepth(obj.root));

	}

}
