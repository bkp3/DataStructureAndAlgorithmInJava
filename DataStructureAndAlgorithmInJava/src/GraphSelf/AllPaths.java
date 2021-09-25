package GraphSelf;

import java.io.*;
import java.util.*;

//Find All Paths in Graph using Depth First Search

/*
7
8
0 1 10
1 2 10
2 3 10
0 3 10
3 4 10
4 5 10
5 6 10
4 6 10
0
6

o/p ->
0123456
012346
03456
0346

*/
public class AllPaths {

	static class Edge {
		int src;
		int nbr;
		int wt;

		Edge(int src, int nbr, int wt) {
			this.src = src;
			this.nbr = nbr;
			this.wt = wt;
		}
	}

	static void allPath(ArrayList<Edge>[] adj, int src, int dst, boolean[] visited, String psf) {
		if (src == dst) {
			System.out.println(psf);
		}
		visited[src] = true;
		for (Edge e : adj[src]) {
			if (visited[e.nbr] == false) {
				allPath(adj, e.nbr, dst, visited, psf + e.nbr);
			}
		}
		visited[src] = false;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int e = Integer.parseInt(br.readLine());

		ArrayList<Edge>[] adj = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			adj[i] = new ArrayList<>();
		}

		for (int i = 0; i < e; i++) {
			String[] parts = br.readLine().split(" ");
			int v1 = Integer.parseInt(parts[0]);
			int v2 = Integer.parseInt(parts[1]);
			int wt = Integer.parseInt(parts[2]);
			adj[v1].add(new Edge(v1, v2, wt));
			adj[v2].add(new Edge(v2, v1, wt));
		}

		int src = Integer.parseInt(br.readLine());
		int dst = Integer.parseInt(br.readLine());

		boolean[] visited = new boolean[n];
		allPath(adj, src, dst, visited, src + "");

	}

}
