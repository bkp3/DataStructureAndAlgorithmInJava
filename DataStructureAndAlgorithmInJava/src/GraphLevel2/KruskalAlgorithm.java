package GraphLevel2;

import java.util.*;
import java.io.*;
/*
Input
7
8
0 1 10
1 2 10
2 3 10
0 3 40
3 4 2
4 5 3
5 6 3
4 6 8
Output
38

*/

public class KruskalAlgorithm {

	static int[] parent;
	static int[] rank;

	static class Pair implements Comparable<Pair> {
		int u;
		int v;
		int wt;

		Pair(int u, int v, int wt) {
			this.u = u;
			this.v = v;
			this.wt = wt;
		}

		@Override
		public int compareTo(Pair o) {
			return this.wt - o.wt;
		}
	}

	static int find(int x) {
		if (parent[x] == x) {
			return x;
		}
		int temp = find(parent[x]);
		parent[x] = temp;
		return temp;
	}

	static boolean union(int x, int y) {
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
			return true;
		} else {
			return false;
		}
	}

	static int mst(int n, int[][] edges) {
		Pair[] arr = new Pair[edges.length];
		for (int i = 0; i < edges.length; i++) {
			arr[i] = new Pair(edges[i][0], edges[i][1], edges[i][2]);
		}
		Arrays.sort(arr);

		parent = new int[n];
		rank = new int[n];
		for (int i = 0; i < n; i++) {
			parent[i] = i;
			rank[i] = 1;
		}

		int ans = 0;
		for (int i = 0; i < arr.length; i++) {
			boolean flag = union(arr[i].u, arr[i].v);
			if (flag == true) {
				ans = ans + arr[i].wt;
			}
		}
		return ans;

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		int[][] edges = new int[m][3];
		for (int i = 0; i < m; i++) {
			String[] parts = br.readLine().split(" ");
			edges[i][0] = Integer.parseInt(parts[0]);
			edges[i][1] = Integer.parseInt(parts[1]);
			edges[i][2] = Integer.parseInt(parts[2]);
		}

		int ans = mst(n, edges);
		System.out.println(ans);

	}

}