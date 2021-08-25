package GraphLevel1;

import java.util.*;
import java.io.*;

/*
i/p ->
7
5
0 1 10
2 3 10
4 5 10
5 6 10
4 6 10

o/p->
//[[0, 1], [2, 3], [4, 5, 6]]
false
*/

public class IsGraphConnected {
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

	public static void drawTree(ArrayList<Edge>[] adj, int src, ArrayList<Integer> comp, boolean[] visited) {
		visited[src] = true;
		comp.add(src);
		for (Edge e : adj[src]) {
			if (!visited[e.nbr]) {
				drawTree(adj, e.nbr, comp, visited);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int e = Integer.parseInt(br.readLine());

		ArrayList<Edge> adj[] = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			adj[i] = new ArrayList<>();
		}

		for (int i = 0; i < e; i++) {
			String[] parts = br.readLine().split(" ");
			int src = Integer.parseInt(parts[0]);
			int nbr = Integer.parseInt(parts[1]);
			int wt = Integer.parseInt(parts[2]);
			adj[src].add(new Edge(src, nbr, wt));
			adj[nbr].add(new Edge(nbr, src, wt));
		}

		ArrayList<ArrayList<Integer>> comps = new ArrayList<>();

		boolean[] visited = new boolean[n];
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				ArrayList<Integer> comp = new ArrayList<>();
				drawTree(adj, i, comp, visited);
				comps.add(comp);
			}
		}

		System.out.println(comps.size() == 1);

	}

}
