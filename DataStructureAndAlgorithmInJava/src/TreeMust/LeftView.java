package TreeMust;

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

		ArrayList<Integer> ans = new ArrayList<>();
		if (root == null) {
			return;
		}
		ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		while (q.size() > 0) {
			int size = q.size();
			ArrayList<Integer> al = new ArrayList<>();
			while (size-- > 0) {
				TreeNode temp = q.remove();
				al.add(temp.data);
				if (temp.left != null) {
					q.add(temp.left);
				}
				if (temp.right != null) {
					q.add(temp.right);
				}
			}
			arr.add(al);
		}
		for (ArrayList<Integer> x : arr) {
			ans.add(x.get(0));
		}
		System.out.println(ans);

	}

	public void lefViewEfficient(TreeNode root) {

		HashMap<Integer, ArrayList<Integer>> mp = new HashMap<>();
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);

		int hd = 0;

		while (!q.isEmpty()) {
			int size = q.size();

			if (!mp.containsKey(hd)) {
				mp.put(hd, new ArrayList<>());
			}

			while (size-- > 0) {
				TreeNode temp = q.poll();
				mp.get(hd).add(temp.data);
				if (temp.left != null) {
					q.offer(temp.left);
				}
				if (temp.right != null) {
					q.offer(temp.right);
				}
			}
			hd++;
		}

		for (Map.Entry<Integer, ArrayList<Integer>> x : mp.entrySet()) {
			System.out.print(x.getValue().get(0) + " ");
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
