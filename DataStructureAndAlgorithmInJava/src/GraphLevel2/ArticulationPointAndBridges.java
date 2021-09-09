package GraphLevel2;

import java.io.*;
import java.util.*;

/*
i/p->
5
5
1 2
1 3
3 2
3 4
5 4

 
o/p-> 
2

*/

public class ArticulationPointAndBridges {
	static int[] parent;
	static int[] disc;
	static int[] low;
	static int time;
	static boolean[] vis;
	static boolean[] ap;

	static void dfs(int u, ArrayList<Integer>[] graph) {
		disc[u] = low[u] = time;
		time++;
		int count = 0;
		vis[u] = true;
		for (int v : graph[u]) {
			if (parent[u] == v) {
				continue;
			} else if (vis[v] == true) {
				low[u] = Math.min(low[u], disc[v]);
			} else {
				parent[v] = u;
				count++;
				dfs(v, graph);
				low[u] = Math.min(low[u], low[v]);
				if (parent[u] == -1) {
					if (count >= 2) {
						ap[u] = true;
					}
				} else {
					if (low[v] >= disc[u]) {
						ap[u] = true;
					}
				}
			}
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int e = Integer.parseInt(br.readLine());

		ArrayList<Integer>[] graph = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < e; i++) {
			String[] parts = br.readLine().split(" ");
			int u = Integer.parseInt(parts[0]);
			int v = Integer.parseInt(parts[1]);
			graph[u - 1].add(v - 1);
			graph[v - 1].add(u - 1);
		}

		parent = new int[n];
		parent[0] = -1;
		disc = new int[n];
		low = new int[n];
		time = 0;
		vis = new boolean[n];
		ap = new boolean[n];

		dfs(0, graph);

		int ans = 0;
		for (int i = 0; i < n; i++) {
			if (ap[i] == true) {
				ans++;
			}
		}
		System.out.println(ans);

	}

}
