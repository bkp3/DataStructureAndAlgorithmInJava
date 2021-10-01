package GraphSelf;

import java.util.*;
import java.io.*;

/*
i/p->
5
5
3 0 3 0 0
3 0 0 0 3
3 3 3 3 3
0 2 3 0 0
3 0 0 1 3

o/p->
false

*/

public class FindWhetherPathExist {
	static boolean res;

	static void dfs(int[][] mat, int i, int j, boolean[][] visited) {
		if (mat[i][j] == 2) {
			res = true;
		}
		visited[i][j] = true;
		int[][] dirs = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
		for (int k = 0; k < 4; k++) {
			int rdash = i + dirs[k][0];
			int cdash = j + dirs[k][1];
			if (rdash < 0 || cdash < 0 || rdash >= mat.length || cdash >= mat[0].length) {
				continue;
			}
			if ((mat[rdash][cdash] == 3 || mat[rdash][cdash] == 2) && visited[rdash][cdash] == false) {
				dfs(mat, rdash, cdash, visited);
			}
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		int[][] mat = new int[n][m];

		for (int i = 0; i < n; i++) {
			String[] parts = br.readLine().split(" ");
			for (int j = 0; j < m; j++) {
				mat[i][j] = Integer.parseInt(parts[j]);
			}
		}

		res = false;
		boolean[][] visited = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (mat[i][j] == 1) {
					dfs(mat, i, j, visited);
				}
			}
		}

		System.out.println(res);

	}

}
