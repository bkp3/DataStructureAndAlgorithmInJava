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
public class DsuRedundantConnectionTwo {
	static int[] parent;
	static int[] rank;

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
			return false;
		} else {
			return true;
		}
	}

	static int[] redCon(int[][] pos) {
		int[] indegree = new int[pos.length];
		Arrays.fill(indegree, -1);
		int bl1 = -1;
		int bl2 = -1;
		for (int i = 0; i < pos.length; i++) {
			int u = pos[i][0];
			int v = pos[i][1];

			if (indegree[v] == -1) {
				indegree[v] = i;
			} else {
				bl1 = i;
				bl2 = indegree[v];
				break;
			}
		}

		parent = new int[pos.length];
		rank = new int[pos.length];
		for (int i = 0; i < pos.length; i++) {
			parent[i] = i;
			rank[i] = 1;
		}

		for (int i = 0; i < pos.length; i++) {
			if (i == bl1) {
				continue;
			}

			int u = pos[i][0];
			int v = pos[i][1];

			boolean flag = union(u, v);
			if (flag == true) {
				if (bl1 == -1) {
					return pos[i];// case 2
				} else {
					return pos[bl2]; // case 3
				}
			}
		}
		return pos[bl1];// case 1
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
