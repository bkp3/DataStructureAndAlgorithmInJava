package GraphLevel2;

import java.io.*;
import java.util.*;

/*
i/p->
5
5
1 1 0 0 0
1 0 0 0 0
0 0 0 1 1
0 0 0 1 0
0 1 0 0 0

o/p->
2
*/
public class NumberOfDistinctIsland {

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

		System.out.println(numDistinctIsland(mat));

	}

	public static StringBuilder psf = new StringBuilder();

	public static int numDistinctIsland(int[][] mat) {
		HashSet<String> set = new HashSet<>();
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				if (mat[i][j] == 1) {
					psf = new StringBuilder();
					psf.append("x");
					dfs(mat, i, j);

					set.add(psf.toString());
				}
			}
		}
		return set.size();
	}

	public static void dfs(int[][] mat, int row, int col) {

		mat[row][col] = 0;

		if (row - 1 >= 0 && mat[row - 1][col] == 1) {
			psf.append("u");
			dfs(mat, row - 1, col);
		}

		if (col + 1 < mat[0].length && mat[row][col + 1] == 1) {
			psf.append("r");
			dfs(mat, row, col + 1);
		}
		if (row + 1 < mat.length && mat[row + 1][col] == 1) {
			psf.append("d");
			dfs(mat, row + 1, col);
		}
		if (col - 1 >= 0 && mat[row][col - 1] == 1) {
			psf.append("l");
			dfs(mat, row, col - 1);
		}

		psf.append("z");

	}

}
