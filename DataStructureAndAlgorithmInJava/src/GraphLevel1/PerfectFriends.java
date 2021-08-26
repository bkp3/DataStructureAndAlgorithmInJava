package GraphLevel1;

import java.util.*;
import java.io.*;

/*
i/p ->
7
5
0 1
2 3
4 5
5 6
4 6

o/p->
[[0, 1], [2, 3], [4, 5, 6]]

*/

public class PerfectFriends {

	static class Edge {
		int src;
		int nbr;

		Edge(int src, int nbr) {
			this.src = src;
			this.nbr = nbr;
		}
	}

	static void drawTree(ArrayList<Edge>[] adj, int src, ArrayList<Integer> comp, boolean[] visited) {
		visited[src] = true;
		comp.add(src);
		for (Edge edge : adj[src]) {
			if (visited[edge.nbr] == false) {
				drawTree(adj, edge.nbr, comp, visited);
			}
		}
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
			int src = Integer.parseInt(parts[0]);
			int nbr = Integer.parseInt(parts[1]);
			adj[src].add(new Edge(src, nbr));
			adj[nbr].add(new Edge(nbr, src));
		}

		ArrayList<ArrayList<Integer>> comps = new ArrayList<>();

		boolean[] visited = new boolean[n];

		for (int i = 0; i < n; i++) {
			if (visited[i] == false) {
				ArrayList<Integer> comp = new ArrayList<>();
				drawTree(adj, i, comp, visited);
				comps.add(comp);
			}
		}

		System.out.println(comps);

		int pairs = 0;
		for (int i = 0; i < comps.size() - 1; i++) {
			int k = 1;
			for (int j = i + 1; j < comps.size(); j++) {
				pairs = pairs + comps.get(i).size() * comps.get(j).size();
			}
		}

		System.out.println(pairs);

	}

}
