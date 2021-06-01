package Tree;

import java.util.*;
/*
output:-
1 2 4 

*/

public class LeftView {
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

	public LeftView() {

	}

	// Level order traversal
	public void leftView(TreeNode root) {
		if (root == null) {
			return;
		}

		HashMap<Integer, ArrayList<Integer>> mp = new HashMap<>();
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);

		q.offer(null);
		int level = 0;
		int nullCount = 1;

		while (!q.isEmpty()) {
			TreeNode temp = q.poll();
			if (temp == null) {
				++nullCount;
				++level;
				if (nullCount == 2) {
					break;
				}
				q.add(null);
			} else {
				if (mp.get(level) == null) {
					mp.put(level, new ArrayList<>());
				}
				mp.get(level).add(temp.data);
				nullCount = 0;
				if (temp.left != null) {
					q.offer(temp.left);
				}
				if (temp.right != null) {
					q.offer(temp.right);
				}
			}

		}

		ArrayList<Integer> ans = new ArrayList<>();

		for (Map.Entry<Integer, ArrayList<Integer>> x : mp.entrySet()) {
			ans.add(x.getValue().get(0));

		}

		for (int x : ans) {
			System.out.print(x + " ");
		}

	}

	public void lefViewEfficient(TreeNode root) {
		ArrayList<Integer> ans = new ArrayList<>();

		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);

		int f = 0;

		while (!q.isEmpty()) {
			int count = q.size();
			while (count-- > 0) {
				TreeNode temp = q.poll();
				if (f == 0) {
					ans.add(temp.data);
				}
				f++;
				if (temp.left != null) {
					q.offer(temp.left);
				}
				if (temp.right != null) {
					q.offer(temp.right);
				}
			}
			f = 0;
		}

		for (int x : ans) {
			System.out.print(x + " ");
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
		LeftView obj = new LeftView();
		obj.createBinaryTree();

		obj.leftView(obj.root);
		System.out.println();
		obj.lefViewEfficient(obj.root);
	}

}
