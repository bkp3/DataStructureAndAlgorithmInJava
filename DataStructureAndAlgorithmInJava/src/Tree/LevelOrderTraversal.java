package Tree;

import java.util.*;

/*
 * output
0 :- 1 
1 :- 2 3 
2 :- 4 5 

*/
public class LevelOrderTraversal {
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

	public LevelOrderTraversal() {

	}

	// Level order traversal
	public void levelOrder(TreeNode root) {
		if (root == null) {
			return;
		}
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

	// level order traversal using map
	public void levelOrderThree(TreeNode root) {
		if (root == null)
			return;

		HashMap<Integer, ArrayList<Integer>> mp = new HashMap<>();
		Queue<TreeNode> q = new LinkedList<>();
		int hd = 0;
		q.offer(root);

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
			System.out.print(x.getKey() + " :- ");
			for (int i = 0; i < x.getValue().size(); i++) {
				System.out.print(x.getValue().get(i) + " ");
			}
			System.out.println();
		}
	}

	// Level order traversal using map
	public void levelOrderTwo(TreeNode root) {
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

		for (Map.Entry<Integer, ArrayList<Integer>> x : mp.entrySet()) {
			System.out.print(x.getKey() + " :- ");
			for (int i = 0; i < x.getValue().size(); i++) {
				System.out.print(x.getValue().get(i) + " ");
			}
			System.out.println();
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
		LevelOrderTraversal obj = new LevelOrderTraversal();
		obj.createBinaryTree();

		obj.levelOrderThree(obj.root);
	}

}
