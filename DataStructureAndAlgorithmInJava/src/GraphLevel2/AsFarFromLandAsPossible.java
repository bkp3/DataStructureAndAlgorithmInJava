package GraphLevel2;

import java.io.*;
import java.util.*;

/*
i/p->
3
4
1 0 0 1
0 0 0 0
1 0 0 1

o/p->
2

*/
public class AsFarFromLandAsPossible {

	static class Pair {
		int row;
		int col;

		Pair(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}

	public static int maxDistance(int[][] mat) {
		Queue<Pair> q = new LinkedList<>();
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				if (mat[i][j] == 1) {
					q.add(new Pair(i, j));
				}
			}
		}

		if (q.size() == 0 || q.size() == mat.length * mat[0].length) {
			return -1;
		}

		int[][] dirs = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

		int level = -1;
		while (q.size() > 0) {
			level++;
			int size = q.size();
			while (size-- > 0) {
				Pair rem = q.remove();

				for (int i = 0; i < dirs.length; i++) {
					int rdash = rem.row + dirs[i][0];
					int cdash = rem.col + dirs[i][1];

					if (rdash >= 0 && cdash >= 0 && rdash < mat.length && cdash < mat[0].length
							&& mat[rdash][cdash] == 0) {
						q.add(new Pair(rdash, cdash));
						mat[rdash][cdash] = 1;

					}
				}
			}
		}
		return level;

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

		int ans = maxDistance(mat);
		System.out.println(ans);

	}

}
