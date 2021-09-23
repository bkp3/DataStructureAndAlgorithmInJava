package GraphSelf;

import java.util.*;
import java.io.*;
/*

Bellman ford - Shortest path for negative edge wt.

i/p->
6
7
0 1 4
1 2 7
2 3 -8
0 3 6
3 4 2
4 5 3
2 5 -2

o/p->

0 -> 0 = 0
0 -> 1 = 4
0 -> 2 = 11
0 -> 3 = 3
0 -> 4 = 5
0 -> 5 = 8



*/

public class BellmanFord {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int e = Integer.parseInt(br.readLine());

		int[][] arr = new int[e][3];

		for (int i = 0; i < e; i++) {
			String[] parts = br.readLine().split(" ");
			arr[i][0] = Integer.parseInt(parts[0]);
			arr[i][1] = Integer.parseInt(parts[1]);
			arr[i][2] = Integer.parseInt(parts[2]);
		}

		int src = 0;
		int[] path = new int[n];
		Arrays.fill(path, Integer.MAX_VALUE);
		path[src] = 0;

		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < e; j++) {

				int u = arr[j][0];
				int v = arr[j][1];
				int wt = arr[j][2];

				if (path[v] > path[u] + wt && path[u] != Integer.MAX_VALUE) {
					path[v] = path[u] + wt;
				}
			}
		}

		for (int i = 0; i < n; i++) {
			System.out.println(0 + " -> " + i + " = " + path[i]);
		}

	}

}
