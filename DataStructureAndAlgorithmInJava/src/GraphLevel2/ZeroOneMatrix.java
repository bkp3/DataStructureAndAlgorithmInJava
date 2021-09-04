package GraphLevel2;

import java.util.*;
import java.io.*;
/*
i/p->
3
3
0 0 0
0 1 0
1 1 1

o/p->
0 0 0 
0 1 0 
1 2 1 

*/

public class ZeroOneMatrix {

	static class Pair {
		int x;
		int y;

		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	private static int[][] dirs = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public static int[][] updateMatrix(int[][] mat) {
		Queue<Pair> q = new LinkedList<>();
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				if (mat[i][j] == 0) {
					q.add(new Pair(i, j));
				} else {
					mat[i][j] = -1;
				}
			}
		}

		while (q.size() > 0) {
			Pair rem = q.remove();

			for (int i = 0; i < dirs.length; i++) {
				int rowdash = rem.x + dirs[i][0];
				int coldash = rem.y + dirs[i][1];

				if (rowdash >= 0 && coldash >= 0 && rowdash < mat.length && coldash < mat[0].length
						&& mat[rowdash][coldash] < 0) {
					mat[rowdash][coldash] = mat[rem.x][rem.y] + 1;
					q.add(new Pair(rowdash, coldash));

				}
			}
		}
		return mat;
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

		int[][] ans = updateMatrix(mat);

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}

	}

}
