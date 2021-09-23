package GraphSelf;

import java.io.*;
import java.util.*;

/*
i/p->
7
8
0 3
0 1
1 2
2 3
4 3
4 5
5 6
4 6

o/p->
4
5
6
0
1
2
3



*/
public class TopologicalSort {

	static void dfs(ArrayList<Integer>[] adj, int src, boolean[] visited, Stack<Integer> st) {
		visited[src] = true;
		for (int x : adj[src]) {
			if (visited[x] == false) {
				dfs(adj, x, visited, st);
			}
		}
		st.push(src);
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

		Stack<Integer> st = new Stack<>();
		boolean[] visited = new boolean[n];
		for (int i = 0; i < n; i++) {
			if (visited[i] == false) {
				dfs(adj, i, visited, st);
			}
		}

		while (st.size() > 0) {
			System.out.println(st.pop());
		}

	}

}
