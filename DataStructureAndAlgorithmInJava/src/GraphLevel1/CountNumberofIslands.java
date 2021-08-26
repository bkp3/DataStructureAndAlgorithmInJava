package GraphLevel1;

import java.util.*;
import java.io.*;

/*
8
8
0 0 1 1 1 1 1 1
0 0 1 1 1 1 1 1
1 1 1 1 1 1 1 0
1 1 0 0 0 1 1 0
1 1 1 1 0 1 1 0
1 1 1 1 0 1 1 0
1 1 1 1 1 1 1 0
1 1 1 1 1 1 1 0

*/

public class CountNumberofIslands {

	public static void drawTree(int[][] arr, int i, int j, boolean[][] visited) {

		if (i < 0 || j < 0 || i >= arr.length || j >= arr[0].length || arr[i][j] == 1 || visited[i][j] == true) {
			return;
		}

		visited[i][j] = true;

		drawTree(arr, i - 1, j, visited);
		drawTree(arr, i, j + 1, visited);
		drawTree(arr, i, j - 1, visited);
		drawTree(arr, i + 1, j, visited);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int m = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[m][n];

		for (int i = 0; i < arr.length; i++) {
			String[] parts = br.readLine().split(" ");
			for (int j = 0; j < arr[0].length; j++) {
				arr[i][j] = Integer.parseInt(parts[j]);
			}
		}

		/*
		 * for (int i = 0; i < arr.length; i++) { for (int j = 0; j < arr[i].length;
		 * j++) { System.out.print(arr[i][j] + " "); } System.out.println(); }
		 */

		boolean[][] visited = new boolean[arr.length][arr[0].length];
		int count = 0;

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j] == 0 && visited[i][j] == false) {
					drawTree(arr, i, j, visited);
					count++;
				}

			}
		}

		System.out.println(count);

	}

}
