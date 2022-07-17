package Tree;

//false
public class SymmetricTree {

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

	static boolean isMirror(TreeNode root1, TreeNode root2) {
		if (root1 == null && root2 == null) {
			return true;
		}
		if (root1 != null && root2 != null && root1.data == root2.data) {
			return isMirror(root1.left, root2.right) && isMirror(root1.right, root2.left);
		}
		return false;
	}

	public boolean isSymmetric(TreeNode root) {
		return isMirror(root, root);
	}

	public static void main(String[] args) {
		SymmetricTree obj = new SymmetricTree();
		obj.createBinaryTree();

		System.out.println(obj.isSymmetric(obj.root));
	}

}
