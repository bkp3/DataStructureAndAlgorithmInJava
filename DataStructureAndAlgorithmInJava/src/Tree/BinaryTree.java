package Tree;
import java.util.*;

public class BinaryTree {
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
	
	public BinaryTree() {
		
	}
	
	// Pre order traverasal (Recursive)
	public void preOrder(TreeNode root) {
		if(root==null) {
			return;
		}
		System.out.print(root.data+" ");
		preOrder(root.left);
		preOrder(root.right);
	}
	
	// Pre Order traversal (Iterative)
	public void preOrderIterative(TreeNode root) {
		if(root==null) {
			return;
		}
		Stack<TreeNode>st = new Stack();
		st.push(root);
		while(!st.empty()) {
			TreeNode temp = st.pop();
			System.out.print(temp.data + " ");
			if(temp.left!=null) {
				st.push(temp.left);
			}
			if(temp.right!=null) {
				st.push(temp.right);
			}
		}
		return;
	}
	
	// In Order Traversal (Recursive)
	public void inOrder(TreeNode root) {
		if(root==null) {
			return;
		}
		inOrder(root.left);
		System.out.print(root.data+" ");
		inOrder(root.right);
	}
	
	// In Order Traversal (Iterative)
	public void inOrderIterative(TreeNode root) {
		if(root == null) {
			return ;
		}
		Stack<TreeNode>st = new Stack<>();
		TreeNode temp = root;
		while(st.isEmpty() || temp!=null) {
			if(temp!=null) {
				st.push(temp);
				temp=temp.left;
			}else {
				temp=st.pop();
				System.out.print(temp.data+" ");
				temp=temp.right;
			}
		}
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
	
	// Level order traversal
	public void levelOrder(TreeNode root) {
		if(root==null) {
			return;
		}
		Queue<TreeNode>q=new LinkedList<>();
		q.offer(root);
		while(!q.isEmpty()) {
			TreeNode temp = q.poll();
			System.out.print(temp.data+" ");
			
			if(temp.left!=null) {
				q.offer(temp.left);
			}
			if(temp.right!=null) {
				q.offer(temp.right);
			}
		}
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
		BinaryTree obj = new BinaryTree();
		obj.createBinaryTree();
		
		//obj.preOrder(obj.root);
		//obj.inOrder(obj.root);
		//obj.postOrder(obj.root);
		obj.levelOrder(obj.root);
	}

}
