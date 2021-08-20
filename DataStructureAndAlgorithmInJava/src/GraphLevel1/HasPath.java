package GraphLevel1;

import java.io.*;
import java.util.*;

// Find Path in Graphs using Depth First Search

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

*/
public class HasPath {

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

	public static boolean hasPathFun(ArrayList<Edge>[] graph, int src, int dst, boolean[] visited) {
		if (src == dst) {
			return true;
		}
		visited[src] = true;
		for (Edge edge : graph[src]) {
			if (!visited[edge.nbr]) {
				boolean b = hasPathFun(graph, edge.nbr, dst, visited);
				if (b) {
					return true;
				}
			}

		}
		return false;

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
			int v1 = Integer.parseInt(parts[0]);
			int v2 = Integer.parseInt(parts[1]);
			int wt = Integer.parseInt(parts[2]);
			graph[v1].add(new Edge(v1, v2, wt));
			graph[v2].add(new Edge(v2, v1, wt));
		}

		int src = Integer.parseInt(br.readLine());
		int dst = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			System.out.print(i + " --> ");
			for (Edge edge : graph[i]) {
				System.out.print(edge.src + " " + edge.nbr + " " + edge.wt + " , ");
			}
			System.out.println();
		}

		boolean[] visited = new boolean[n];
		boolean ans = hasPathFun(graph, src, dst, visited);
		System.out.println(ans);

	}

}
