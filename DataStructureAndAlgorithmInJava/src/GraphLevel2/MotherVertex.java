package GraphLevel2;

import java.util.*;
import java.io.*;
/*
i/p->
7
8
0 1
0 2
1 3
4 1
6 4
5 6
5 2
6 0

o/p->
5


*/

public class MotherVertex {

	static class Edge {
		int src;
		int nbr;

		Edge(int src, int nbr) {
			this.src = src;
			this.nbr = nbr;
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
			int v1 = Integer.parseInt(parts[0]);
			int v2 = Integer.parseInt(parts[1]);
			graph[v1].add(new Edge(v1, v2));
		}

		int ans = findMotherVertext(n, graph);
		System.out.println(ans);

	}

	public static int findMotherVertext(int n, ArrayList<Edge>[] graph) {
		boolean[] visited = new boolean[n];
		Stack<Integer> st = new Stack<>();
		for (int i = 0; i < n; i++) {
			if (visited[i] == false) {
				dfsUtils(graph, i, visited, st);
			}
		}

		int ans = st.pop();
		visited = new boolean[n];
		count = 0;

		dfsUtilsTwo(graph, ans, visited);
		System.out.println(count);
		if (n == count) {

			return ans;
		} else {
			return -1;
		}

	}

	static int count = 0;

	public static void dfsUtils(ArrayList<Edge>[] graph, int src, boolean[] visited, Stack<Integer> st) {
		visited[src] = true;
		for (Edge e : graph[src]) {
			if (visited[e.nbr] == false) {
				dfsUtils(graph, e.nbr, visited, st);
			}
		}
		st.push(src);

	}

	public static void dfsUtilsTwo(ArrayList<Edge>[] graph, int src, boolean[] visited) {
		visited[src] = true;
		count++;
		for (Edge e : graph[src]) {
			if (visited[e.nbr] == false) {
				dfsUtilsTwo(graph, e.nbr, visited);
			}
		}

	}

}
