package GraphLevel2;

import java.util.*;
import java.io.*;

/*
i/p->
3
5
1 1 0 0 1
1 1 0 0 1
1 1 0 0 0

o/p->
2


*/

public class ShortestBridge {

	static class Pair {
		int row;
		int col;

		Pair(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}

	static int[][] dirs = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

	static void dfs(int i, int j, int[][] mat, boolean[][] visited, Queue<Pair> q) {
		visited[i][j] = true;
		q.add(new Pair(i, j));

		for (int k = 0; k < dirs.length; k++) {
			int rdash = i + dirs[k][0];
			int cdash = j + dirs[k][1];

			if (rdash >= 0 && cdash >= 0 && rdash < mat.length && cdash < mat[0].length
					&& visited[rdash][cdash] == false && mat[rdash][cdash] == 1) {
				dfs(rdash, cdash, mat, visited, q);
			}
		}
	}

	static int shortestBridge(int[][] mat) {
		Queue<Pair> q = new LinkedList<>();
		boolean[][] visited = new boolean[mat.length][mat[0].length];
		boolean flag = false;
		for (int i = 0; i < mat.length && !flag; i++) {
			for (int j = 0; j < mat[0].length && !flag; j++) {
				if (mat[i][j] == 1) {
					dfs(i, j, mat, visited, q);
					flag = true;
				}
			}
		}

		int level = -1;
		while (q.size() > 0) {
			int size = q.size();
			level++;
			while (size-- > 0) {
				Pair rem = q.remove();

				for (int i = 0; i < dirs.length; i++) {
					int rdash = rem.row + dirs[i][0];
					int cdash = rem.col + dirs[i][1];

					if (rdash >= 0 && cdash >= 0 && rdash < mat.length && cdash < mat[0].length
							&& visited[rdash][cdash] == false) {
						if (mat[rdash][cdash] == 1) {
							return level;
						}
						q.add(new Pair(rdash, cdash));
					}
				}
			}
		}

		return -1;

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int m = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());

		int[][] mat = new int[m][n];
		for (int i = 0; i < m; i++) {
			String[] parts = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				mat[i][j] = Integer.parseInt(parts[j]);
			}
		}

		int ans = shortestBridge(mat);
		System.out.println(ans);

	}

}
