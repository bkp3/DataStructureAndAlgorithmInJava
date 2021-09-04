package GraphLevel2;

import java.util.*;
import java.io.*;

/*
i/p->
5
5
0 0 0 1 0
0 1 1 0 0
0 1 0 0 1
0 0 1 0 0
0 0 1 0 0

o/p->
3
*/
public class NumberOfEnclaves {

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

		int ans = numberOfEnclave(mat);
		System.out.println(ans);

	}

	public static int numberOfEnclave(int[][] mat) {

		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				if (i == 0 || j == 0 || i == mat.length - 1 || j == mat[0].length - 1) {
					if (mat[i][j] == 1) {
						dfs(mat, i, j);
					}
				}
			}
		}
		int count = 0;
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				if (mat[i][j] == 1) {
					count++;
				}
			}
		}
		return count;

	}

	public static void dfs(int[][] mat, int i, int j) {

		if (i < 0 || j < 0 || i >= mat.length || j >= mat[0].length || mat[i][j] == 0) {
			return;
		}

		mat[i][j] = 0;

		dfs(mat, i + 1, j);
		dfs(mat, i - 1, j);
		dfs(mat, i, j + 1);
		dfs(mat, i, j - 1);
	}

}
