package GraphSelf;

import java.util.*;
import java.io.*;

/*
i/p->
5
5
0 1
1 4
4 3
4 2
2 3

o/p->
[1, 4]


*/
public class ArticulationPoints {

	static int value;

	static void dfs(ArrayList<Integer>[] adj, int src, boolean[] visited, int parent, Set<Integer> set, int[] disc,
			int[] low) {
		visited[src] = true;
		disc[src] = low[src] = ++value;
		int child = 0;
		for (int x : adj[src]) {
			if (visited[x] == false) {
				child++;
				dfs(adj, x, visited, src, set, disc, low);
				low[src] = Math.min(low[x], low[src]);
				if (parent != -1 && low[x] >= disc[src]) {
					set.add(src);
				}
			}
			if (visited[x] == true && x != parent) {
				low[src] = Math.min(disc[x], low[src]);
			}
		}

		if (parent == -1 && child > 1) {
			set.add(src);
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
			String[] str = br.readLine().split(" ");
			int src = Integer.parseInt(str[0]);
			int nbr = Integer.parseInt(str[1]);
			adj[src].add(nbr);
			adj[nbr].add(src);
		}

		Set<Integer> set = new HashSet<>();
		boolean[] visited = new boolean[n];
		int[] disc = new int[n];
		int[] low = new int[n];
		value = 0;

		for (int i = 0; i < n; i++) {
			if (visited[i] == false) {
				dfs(adj, i, visited, -1, set, disc, low);
			}
		}
		ArrayList<Integer> ans = new ArrayList<>();
		if (set.size() == 0) {
			ans.add(-1);
		} else {
			for (int x : set) {
				ans.add(x);
			}
		}
		Collections.sort(ans);
		System.out.println(ans);

	}

}
