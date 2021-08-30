package GraphLevel2;

import java.io.*;
import java.util.*;

/*
i/p->

6
6
0 1 1
1 2 2
2 3 3
3 4 -4
4 1 -5
3 5 6

o/p->

true

*/

public class NegativeWeightCycleDetection {

	private static boolean isNegativeCycle(int n, int e, int[][] arr) {
		int[] path = new int[n];
		Arrays.fill(path, Integer.MAX_VALUE);
		path[0] = 0;

		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < e; j++) {
				int u = arr[j][0];
				int v = arr[j][1];
				int wt = arr[j][2];

				if (path[u] == Integer.MAX_VALUE) {
					continue;
				}

				if (path[u] + wt < path[v]) {
					path[v] = path[u] + wt;
				}
			}
		}

		for (int j = 0; j < e; j++) {
			int u = arr[j][0];
			int v = arr[j][1];
			int wt = arr[j][2];

			if (path[u] == Integer.MAX_VALUE) {
				continue;
			}

			if (path[u] + wt < path[v]) {
				return true;
			}
		}

		return false;
	}

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

		boolean isNegCycle = isNegativeCycle(n, e, arr);
		System.out.println(isNegCycle);

	}

}
