package GraphSelf;

import java.util.*;
import java.io.*;
/*
shortest distance between (0,0) to (n-1,m-1)
i/p->
4
4
9 4 9 9
6 7 6 4
8 3 3 7
7 4 9 10

o/p->43

*/

public class DijkstraMatrix {

	static class Pair implements Comparable<Pair> {
		int x;
		int y;
		int dist;

		Pair(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}

		@Override
		public int compareTo(Pair o) {
			return this.dist - o.dist;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		int[][] mat = new int[n][m];
		for (int i = 0; i < n; i++) {
			String[] str = br.readLine().split(" ");
			for (int j = 0; j < m; j++) {
				mat[i][j] = Integer.parseInt(str[j]);
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

		PriorityQueue<Pair> pq = new PriorityQueue<>();
		pq.add(new Pair(0, 0, dist[0][0]));

		while (pq.size() > 0) {
			Pair rem = pq.remove();

			for (int i = 0; i < 4; i++) {
				int rdash = rem.x + dirs[i][0];
				int cdash = rem.y + dirs[i][1];
				if (rdash < 0 || cdash < 0 || rdash >= n || cdash >= m) {
					continue;
				}
				if (dist[rdash][cdash] > dist[rem.x][rem.y] + mat[rdash][cdash]) {

					if (dist[rdash][cdash] != Integer.MAX_VALUE) {
						pq.remove(new Pair(rdash, cdash, dist[rdash][cdash]));
					}

					dist[rdash][cdash] = dist[rem.x][rem.y] + mat[rdash][cdash];
					pq.add(new Pair(rdash, cdash, dist[rdash][cdash]));
				}
			}
		}

		System.out.println(dist[n - 1][m - 1]);

	}

}
