package GraphSelf;

import java.util.*;
import java.io.*;
/*
i/p->
7
8
0 3
0 1
1 2
3 2
5 6
4 5
4 6
3 4
2

o/p->
2
1
0
3
4
5
6


*/

public class Dfs {
	static void dfs(ArrayList<Integer>[] adj, int src, boolean[] visited) {
		visited[src] = true;
		System.out.println(src);
		for (int x : adj[src]) {
			if (visited[x] == false) {
				dfs(adj, x, visited);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int e = Integer.parseInt(br.readLine());
		ArrayList<Integer>[] adj = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			adj[i] = new ArrayList<>();
		}

		for (int i = 0; i < e; i++) {
			String[] parts = br.readLine().split(" ");
			int v1 = Integer.parseInt(parts[0]);
			int v2 = Integer.parseInt(parts[1]);
			adj[v1].add(v2);
			adj[v2].add(v1);
		}

		int src = Integer.parseInt(br.readLine());
		boolean[] visited = new boolean[n];
		dfs(adj, src, visited);

	}

}
