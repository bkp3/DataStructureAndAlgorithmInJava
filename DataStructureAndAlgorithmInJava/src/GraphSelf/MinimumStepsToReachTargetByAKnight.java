package GraphSelf;

import java.util.*;
import java.io.*;

/*
i/p->
6
3 4
0 0

o/p->
Minimum Steps :- 3

*/
public class MinimumStepsToReachTargetByAKnight {

	static class Cell {
		int x;
		int y;
		int dist;

		Cell(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		String[] knightPos = br.readLine().split(" ");
		String[] targetPos = br.readLine().split(" ");

		int knightX = Integer.parseInt(knightPos[0]);
		int knightY = Integer.parseInt(knightPos[1]);

		int targetX = Integer.parseInt(targetPos[0]);
		int targetY = Integer.parseInt(targetPos[1]);

		int[][] dirs = { { -2, -1 }, { -1, -2 }, { 1, -2 }, { 2, -1 }, { -2, 1 }, { -1, 2 }, { 1, 2 }, { 2, 1 } };

		Queue<Cell> q = new LinkedList<>();
		boolean[][] visited = new boolean[n][n];

		q.add(new Cell(knightX, knightY, 0));
		visited[knightX][knightY] = true;

		int ans = Integer.MAX_VALUE;
		while (q.size() > 0) {
			Cell rem = q.remove();

			if (rem.x == targetX && rem.y == targetY) {
				ans = rem.dist;
				break;
			}

			for (int i = 0; i < dirs.length; i++) {
				int rdash = rem.x + dirs[i][0];
				int cdash = rem.y + dirs[i][1];

				if (rdash < 0 || cdash < 0 || rdash >= n || cdash >= n) {
					continue;
				}

				if (visited[rdash][cdash] == false) {
					visited[rdash][cdash] = true;
					q.add(new Cell(rdash, cdash, rem.dist + 1));
				}
			}
		}

		System.out.println("Minimum Steps :- " + ans);

	}

}
