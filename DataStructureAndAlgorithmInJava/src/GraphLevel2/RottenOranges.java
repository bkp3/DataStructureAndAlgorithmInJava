package GraphLevel2;

import java.util.*;
import java.io.*;
/*
5
5
2 0 1 0 0
1 1 1 0 0
0 0 0 0 0
0 0 1 1 1
0 1 1 2 0

note:-
0 - empty cell
1 - fresh orange
2 - rotten orange

o/p->

4


*/

public class RottenOranges {

	static class Pair {
		int row;
		int col;

		Pair(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}

	public static int orangrRotting(int[][] mat) {
		Queue<Pair> q = new LinkedList<>();
		int fresh = 0;

		// add all rotten oranges in queue
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				if (mat[i][j] == 2) {
					q.add(new Pair(i, j));
				} else if (mat[i][j] == 1) {
					fresh++;
				}
			}
		}

		if (fresh == 0) {
			return 0;
		}

		int[][] dirs = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

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
							&& mat[rdash][cdash] == 1) {
						q.add(new Pair(rdash, cdash));
						mat[rdash][cdash] = 0;
						fresh--;
					}
				}
			}
		}

		if (fresh == 0) {
			return level;
		} else {
			return -1;
		}

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

		int ans = orangrRotting(mat);
		System.out.println(ans);

	}

}
