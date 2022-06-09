package Tree;

import java.util.*;

public class VerticalOrderTraversal {

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

	class Pair {
		int hd;
		TreeNode node;

		Pair(int hd, TreeNode node) {
			this.hd = hd;
			this.node = node;
		}
	}

	void verticalOrder(TreeNode root) {
		TreeMap<Integer, ArrayList<Integer>> m = new TreeMap<>();
		int hd = 0;
		Queue<Pair> q = new LinkedList<Pair>();
		q.add(new Pair(0, root));

		while (!q.isEmpty()) {

			Pair temp = q.poll();
			hd = temp.hd;
			TreeNode node = temp.node;
			if (m.containsKey(hd)) {
				m.get(hd).add(node.data);
			} else {
				ArrayList<Integer> al = new ArrayList<>();
				al.add(node.data);
				m.put(hd, al);
			}
			if (node.left != null)
				q.add(new Pair(hd - 1, node.left));
			if (node.right != null)
				q.add(new Pair(hd + 1, node.right));
		}

		for (Map.Entry<Integer, ArrayList<Integer>> entry : m.entrySet()) {
			ArrayList<Integer> al = entry.getValue();
			for (Integer i : al)
				System.out.print(i + " ");
			System.out.println();
		}

	}

	public static void main(String[] args) {

		VerticalOrderTraversal obj = new VerticalOrderTraversal();
		obj.createBinaryTree();
		obj.verticalOrder(obj.root);
	}

}
