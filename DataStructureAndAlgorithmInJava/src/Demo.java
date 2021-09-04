import java.util.*;

import GraphLevel1.TopologicalSortAlgorithm;

import java.io.*;

public class Demo {

	static class Edge {
		int src;
		int nbr;

		Edge(int src, int nbr) {
			this.src = src;
			this.nbr = nbr;
		}
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
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
			graph[v2].add(new Edge(v2, v1));

		}

		boolean[] visited = new boolean[n];
		Stack<Integer> st = new Stack<>();

		for (int i = 0; i < n; i++) {
			if (visited[i] == false) {
				topologicalFun(graph, i, visited, st);
			}
		}

		while (st.size() > 0) {
			System.out.println(st.pop());
		}

	}

	public static void topologicalFun(ArrayList<Edge>[] graph, int src, boolean[] visited, Stack<Integer> st) {
		visited[src] = true;
		for (Edge e : graph[src]) {
			if (visited[e.nbr] == false) {
				topologicalFun(graph, e.nbr, visited, st);
			}
		}
		st.add(src);
	}

}
