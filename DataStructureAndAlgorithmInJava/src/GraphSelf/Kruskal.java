package GraphSelf;

import java.io.*;
import java.util.*;
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

public class Kruskal {

	static int[] parent;
	static int[] rank;

	static class Pair implements Comparable<Pair> {
		int src;
		int nbr;
		int wt;

		Pair(int src, int nbr, int wt) {
			this.src = src;
			this.nbr = nbr;
			this.wt = wt;
		}

		@Override
		public int compareTo(Pair o) {
			return this.wt - o.wt;
		}
	}

	static int find(int x) {
		if (x == parent[x]) {
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
		}
		return false;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int e = Integer.parseInt(br.readLine());

		int[][] mat = new int[e][3];
		for (int i = 0; i < e; i++) {
			String[] parts = br.readLine().split(" ");
			mat[i][0] = Integer.parseInt(parts[0]);
			mat[i][1] = Integer.parseInt(parts[1]);
			mat[i][2] = Integer.parseInt(parts[2]);
		}

		Pair[] arr = new Pair[e];
		for (int i = 0; i < e; i++) {
			arr[i] = new Pair(mat[i][0], mat[i][1], mat[i][2]);
		}
		Arrays.sort(arr);

		parent = new int[n];
		rank = new int[n];

		for (int i = 0; i < n; i++) {
			parent[i] = i;
			rank[i] = 1;
		}

		int ans = 0;
		for (int i = 0; i < e; i++) {
			boolean flag = union(arr[i].src, arr[i].nbr);
			if (flag == true) {
				ans = ans + arr[i].wt;
			}
		}

		System.out.println(ans);

	}

}
