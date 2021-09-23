package GraphSelf;

import java.util.*;
import java.io.*;
/*
floyd warshall ->  All Pairs Shortest Path
infinity - 99999

i/p->
4
0 5 99999 10
99999 0 3 99999
99999 99999 0 1
99999 99999 99999 0

o/p->
0 5 8 9 
99999 0 3 4 
99999 99999 0 1 
99999 99999 99999 0 


*/

public class FloydWarshall {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[][] dist = new int[n][n];

		for (int i = 0; i < n; i++) {
			String[] parts = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				dist[i][j] = Integer.parseInt(parts[j]);
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					if (dist[i][j] > dist[i][k] + dist[k][j]) {
						dist[i][j] = dist[i][k] + dist[k][j];
					}
				}
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(dist[i][j] + " ");
			}
			System.out.println();
		}

	}

}
