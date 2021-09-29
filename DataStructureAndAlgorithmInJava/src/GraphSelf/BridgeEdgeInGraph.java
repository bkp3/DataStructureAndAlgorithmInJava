package GraphSelf;

import java.util.*;
import java.io.*;

/*
i/p->
4
3
0 1
1 2
2 3


o/p->
3 - bridges present in graph
2 3
1 2
0 1

*/

public class BridgeEdgeInGraph {

	static int time;

	static class Pair {
		int x;
		int y;

		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static void dfs(ArrayList<Integer>[] adj, int src, boolean[] visited, int[] disc, int[] low, int[] parent, ArrayList<Pair> ans) {
		visited[src] = true;
		disc[src] = ++time;
		low[src] = ++time;

		for (int x : adj[src]) {
			if (visited[x] == false) {
				parent[x] = src;
				dfs(adj, x, visited, disc, low, parent, ans);
				low[src] = Math.min(low[src], low[x]);
				if (low[x] > disc[src]) {
					ans.add(new Pair(src, x));
				}

			} else if (x != parent[src])
				low[src] = Math.min(low[src], disc[x]);
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

		time = 0;
		ArrayList<Pair> ans = new ArrayList<>();

		boolean[] visited = new boolean[n];
		int disc[] = new int[n];
		int low[] = new int[n];
		int parent[] = new int[n];

		for (int i = 0; i < n; i++) {
			parent[i] = -1;
		}

		for (int i = 0; i < n; i++) {
			if (visited[i] == false) {
				dfs(adj, i, visited, disc, low, parent, ans);
			}
		}

		System.out.println(ans.size() + " - bridges present in graph");
		for (Pair p : ans) {
			System.out.println(p.x + " " + p.y);
		}

	}

}
