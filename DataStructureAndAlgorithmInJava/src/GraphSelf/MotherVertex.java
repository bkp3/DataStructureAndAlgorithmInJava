package GraphSelf;

import java.util.*;
import java.io.*;

/*
A Mother Vertex is a vertex through which we can reach all the other vertices of the Graph.
i/p->
7
8
0 1
0 2
1 3
4 1
6 4
5 6
5 2
6 0

o/p->
Mother Vertext:- 5


i/p->
3
2
0 1
2 1

o/p->
Mother Vertext:- -1

*/

public class MotherVertex {

	static void dfs(ArrayList<Integer>[] adj, int src, boolean[] visited) {
		visited[src] = true;
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
		}

		boolean[] visited = new boolean[n];
		int v = -1;

		for (int i = 0; i < n; i++) {
			if (visited[i] == false) {
				dfs(adj, i, visited);
				v = i;
			}
		}

		visited = new boolean[n];
		dfs(adj, v, visited);

		for (int i = 0; i < n; i++) {
			if (visited[i] == false) {
				v = -1;
				break;
			}
		}
		System.out.println("Mother Vertext:- " + v);

	}

}
