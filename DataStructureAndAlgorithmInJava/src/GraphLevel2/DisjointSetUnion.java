package GraphLevel2;

import java.io.*;
import java.util.*;

/*


o/p->
Yes
No
*/
class DisjointSetUnion {
	static int[] rank, parent;
	int n;

	public DisjointSetUnion(int n) {
		rank = new int[n];
		parent = new int[n];
		this.n = n;
		for (int i = 0; i < n; i++) {
			parent[i] = i;
		}

	}

	int find(int x) {
		if (parent[x] == x) {
			return x;
		}
		int temp = find(parent[x]);
		parent[x] = temp;
		return temp;
	}

	void union(int x, int y) {
		// leader x, leader y
		int lx = find(x);
		int ly = find(y);
		if (lx != ly) {
			if (rank[lx] > rank[ly]) {
				parent[ly] = lx;
			} else if (rank[lx] < rank[ly]) {
				parent[lx] = ly;
			} else {
				parent[lx] = ly;
				rank[ly]++;
			}
		}
	}

	public static void main(String[] args) {
		int n = 5;
		DisjointSetUnion dus = new DisjointSetUnion(n);
		dus.union(0, 2);
		dus.union(4, 2);
		dus.union(3, 1);

		if (dus.find(4) == dus.find(0))
			System.out.println("Yes");
		else
			System.out.println("No");

		if (dus.find(1) == dus.find(0))
			System.out.println("Yes");
		else
			System.out.println("No");
	}
}
