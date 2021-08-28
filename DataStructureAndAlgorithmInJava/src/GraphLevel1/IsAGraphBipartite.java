package GraphLevel1;

import java.util.*;
import java.io.*;

/*
Bipartite 
:- if it is possible to divide vertices 2 mutually exclusive and exhaustive sets such that all edges are cross sets.
:- Every non cyclic graph is bipartite.
:- if a graph is cyclic then number of edges must in even number.

i/p->
4
4
0 1 10
0 3 10
1 2 10
2 3 10

o/p ->
true

*/

public class IsAGraphBipartite {

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

	static class Pair {
		int v;
		String psf;
		int level;

		Pair(int v, String psf, int level) {
			this.v = v;
			this.psf = psf;
			this.level = level;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int e = Integer.parseInt(br.readLine());

		ArrayList<Edge>[] graph = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < e; i++) {
			String[] parts = br.readLine().split(" ");
			int src = Integer.parseInt(parts[0]);
			int dst = Integer.parseInt(parts[1]);
			int wt = Integer.parseInt(parts[2]);
			graph[src].add(new Edge(src, dst, wt));
			graph[dst].add(new Edge(dst, src, wt));
		}

		int[] visited = new int[n];
		Arrays.fill(visited, -1);

		for (int i = 0; i < n; i++) {
			if (visited[i] == -1) {
				boolean isCompBipartite = checkComponentForBipartiteness(graph, i, visited);
				if (isCompBipartite == false) {
					System.out.println(false);
					return;
				}
			}
		}
		System.out.println(true);

	}

	static boolean checkComponentForBipartiteness(ArrayList<Edge>[] graph, int src, int[] visited) {
		ArrayDeque<Pair> q = new ArrayDeque<>();

		q.add(new Pair(src, src + "", 0));

		while (q.size() > 0) {
			// rm*wa*
			Pair rem = q.removeFirst();

			if (visited[rem.v] != -1) {
				// some work to do
				if (rem.level != visited[rem.v]) {
					return false;
				}

			} else {
				visited[rem.v] = rem.level;
			}

			for (Edge e : graph[rem.v]) {
				if (visited[e.nbr] == -1) {
					q.add(new Pair(e.nbr, rem.psf + e.nbr, rem.level + 1));
				}
			}

		}
		return true;

	}

}
