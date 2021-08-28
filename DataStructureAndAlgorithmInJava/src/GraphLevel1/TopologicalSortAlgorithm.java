package GraphLevel1;

import java.util.*;
import java.io.*;
/*
Topological sort :- A permutation of vertices for a directed acyclic graph(DAG) is called topological sort if
					for all directed edges uv, u appears before vin the graph.

*/

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
public class TopologicalSortAlgorithm {

	static class Edge {
		int src;
		int nbr;

		Edge(int src, int nbr) {
			this.src = src;
			this.nbr = nbr;
		}
	}

	public static void topologicalSort(ArrayList<Edge>[] graph, int src, boolean[] visited, Stack<Integer> st) {
		visited[src] = true;
		for (Edge e : graph[src]) {
			if (visited[e.nbr] == false) {
				topologicalSort(graph, e.nbr, visited, st);
			}
		}
		st.push(src);

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
			graph[v1].add(new Edge(v1, v2));
		}

		boolean[] visited = new boolean[n];
		Stack<Integer> st = new Stack<>();

		for (int i = 0; i < n; i++) {
			if (visited[i] == false) {
				topologicalSort(graph, i, visited, st);
			}
		}

		while (st.size() > 0) {
			System.out.println(st.pop());
		}

	}

}
