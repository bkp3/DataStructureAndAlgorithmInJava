package GraphSelf;

import java.util.*;
import java.io.*;

/*
i/p->
4
4
9 4 9 9
6 7 6 4
8 3 3 7
7 4 9 10

o/p->
minimum distance between top left to bottom right is:- 43

*/
public class MinimumCostPath {

	static class Cell implements Comparable<Cell> {
		int x;
		int y;
		int dist;

		Cell(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}

		@Override
		public int compareTo(Cell o) {
			return this.dist - o.dist;
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

		int[][] dist = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				dist[i][j] = Integer.MAX_VALUE;
			}
		}
		dist[0][0] = mat[0][0];

		int[][] dirs = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

		PriorityQueue<Cell> pq = new PriorityQueue<>();
		pq.add(new Cell(0, 0, dist[0][0]));

		while (pq.size() > 0) {
			Cell rem = pq.remove();

			for (int i = 0; i < 4; i++) {
				int rdash = rem.x + dirs[i][0];
				int cdash = rem.y + dirs[i][1];

				if (rdash < 0 || cdash < 0 || rdash >= n || cdash >= m) {
					continue;
				}

				if (dist[rdash][cdash] > dist[rem.x][rem.y] + mat[rdash][cdash]) {
					if (dist[rdash][cdash] != Integer.MAX_VALUE) {
						pq.remove(new Cell(rdash, cdash, dist[rdash][cdash]));
					}
					dist[rdash][cdash] = dist[rem.x][rem.y] + mat[rdash][cdash];
					pq.add(new Cell(rdash, cdash, dist[rdash][cdash]));

				}

			}
		}

		System.out.println("minimum distance between top left to bottom right is:- " + dist[n - 1][m - 1]);
	}

}
