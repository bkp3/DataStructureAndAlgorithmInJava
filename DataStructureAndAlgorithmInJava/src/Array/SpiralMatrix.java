package Array;

import java.util.ArrayList;
import java.util.List;

//[1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10]
public class SpiralMatrix {

	public static void main(String[] args) {
		int mat[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };

		int m = mat.length;
		int n = mat[0].length;
		List<Integer> ans = new ArrayList<>();
		boolean[][] seen = new boolean[m][n];
		int[] dr = { 0, 1, 0, -1 };
		int[] dc = { 1, 0, -1, 0 };
		int x = 0;
		int y = 0;
		int di = 0;
		for (int i = 0; i < m * n; i++) {
			ans.add(mat[x][y]);
			seen[x][y] = true;
			int cr = x + dr[di];
			int cc = y + dc[di];
			if (0 <= cr && cr < m && 0 <= cc && cc < n && !seen[cr][cc]) {
				x = cr;
				y = cc;
			} else {
				di = (di + 1) % 4;
				x = x + dr[di];
				y = y + dc[di];
			}
		}
		System.out.println(ans);

	}

}
