package GraphLevel2;

import java.util.*;
import java.io.*;

/*
i/p->
3
3
4
0 0
0 1
1 2
2 1

o/p->
number of island in each operations:-
[1, 1, 2, 3]


*/
public class DsuNumberOfIsland {

	static ArrayList<Integer> numIsland2(int m, int n, int[][] pos) {
		ArrayList<Integer> ans = new ArrayList<>();
		int[][] dirs = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

		int[] par = new int[m * n];
		int[] rank = new int[m * n];
		Arrays.fill(par, -1);
		int count = 0;

		for (int i = 0; i < pos.length; i++) {
			int row = pos[i][0];
			int col = pos[i][1];

			int cellno = row * n + col;
			if (par[cellno] != -1) {
				ans.add(count);
				continue;
			}
			par[cellno] = cellno;
			rank[cellno] = 1;
			count++;

			for (int j = 0; j < dirs.length; j++) {
				int rdash = row + dirs[j][0];
				int cdash = col + dirs[j][1];
				int celldash = rdash * n + cdash;

				if (rdash < 0 || cdash < 0 || rdash >= m || cdash >= n || par[celldash] == -1) {
					continue;
				}

				int lx = find(cellno, par);
				int ly = find(celldash, par);

				if (lx != ly) {
					if (rank[lx] > rank[ly]) {
						par[ly] = lx;
					} else if (rank[lx] < rank[ly]) {
						par[lx] = ly;
					} else {
						par[ly] = lx;
						rank[lx]++;
					}
					count--;
				}

			}
			ans.add(count);
		}

		return ans;
	}

	static int find(int x, int[] par) {
		if (par[x] == x) {
			return x;
		}
		int temp = find(par[x], par);
		par[x] = temp;
		return temp;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int m = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		int q = Integer.parseInt(br.readLine());

		int[][] pos = new int[q][2];
		for (int i = 0; i < q; i++) {
			String[] parts = br.readLine().split(" ");
			pos[i][0] = Integer.parseInt(parts[0]);
			pos[i][1] = Integer.parseInt(parts[1]);
		}

		ArrayList<Integer> ans = numIsland2(m, n, pos);
		System.out.println(ans);

	}

}
