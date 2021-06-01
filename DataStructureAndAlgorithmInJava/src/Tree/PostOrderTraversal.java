package Tree;
import java.util.*;

public class PostOrderTraversal {
	private TreeNode root;
	
	private class TreeNode{
		private TreeNode left;
		private TreeNode right;
		private int data;
		
		public TreeNode(int data) {
			this.data=data;
			this.left=null;
			this.right=null;
		}
	}
	
	public PostOrderTraversal() {
		
	}
	
	// Post Order Traversal (Recursive)
	public void postOrder(TreeNode root) {
		if(root==null) {
			return;
		}
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.data+" ");
	}
	
	public void createBinaryTree() {
		TreeNode first = new TreeNode(1);
		TreeNode second = new TreeNode(2);
		TreeNode third = new TreeNode(3);
		TreeNode fourth = new TreeNode(4);
		TreeNode fifth = new TreeNode(5);
		
		root=first;
		first.left=second;
		first.right=third;
		
		second.left=fourth;
		second.right=fifth;
	}
	
	
	public static void main(String[] args) {
		PostOrderTraversal obj = new PostOrderTraversal();
		obj.createBinaryTree();
		
		obj.postOrder(obj.root);
		
	}

}
