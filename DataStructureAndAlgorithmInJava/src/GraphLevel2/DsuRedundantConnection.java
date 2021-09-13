package GraphLevel2;

import java.util.*;
import java.io.*;

/*
Constraints
1<= n <= 10000
number of edge = number of vertices
Input
3
1 2
1 3
2 3
Output
2 3

*/
public class DsuRedundantConnection {
	static int[] redCon(int[][] pos) {
		int[] parent = new int[pos.length];
		int[] rank = new int[pos.length];
		for (int i = 0; i < pos.length; i++) {
			rank[i] = 1;
			parent[i] = i;
		}

		for (int i = 0; i < pos.length; i++) {
			int u = pos[i][0];
			int v = pos[i][1];

			int lu = find(parent, u);
			int lv = find(parent, v);

			if (lu != lv) {
				if (rank[lu] > rank[lv]) {
					parent[lv] = lu;
				} else if (rank[lu] < rank[lv]) {
					parent[lu] = lv;
				} else {
					parent[lu] = lv;
					rank[lv]++;
				}
			} else {
				int[] ans = { u, v };
				return ans;
			}
		}
		return new int[2];

	}

	static int find(int[] parent, int x) {
		if (parent[x] == x) {
			return x;
		}
		int temp = find(parent, parent[x]);
		parent[x] = temp;
		return temp;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] pos = new int[n][2];
		for (int i = 0; i < n; i++) {
			String[] parts = br.readLine().split(" ");
			pos[i][0] = Integer.parseInt(parts[0]) - 1;
			pos[i][1] = Integer.parseInt(parts[1]) - 1;
		}

		int[] ans = redCon(pos);
		System.out.println((ans[0] + 1) + " " + (ans[1] + 1));

	}

}
