package GraphLevel2;

import java.util.*;
import java.io.*;

/*
Kosaraju Algorithm steps:-
step 1:- random order dfs(stack add before backtrack)
step 2:- reverse all the edges
step 3:- do dfs in the order arranged in stack

i/p->
5
6
1 4
1 3
2 4
3 4
4 5
5 1


o/p->
2



*/
public class KosarajuAlgorithm {

	public static void dfs1(ArrayList<Integer>[] graph, int src, Stack<Integer> st, boolean[] visited) {

		visited[src] = true;
		for (int v : graph[src]) {
			if (visited[v] == false) {
				dfs1(graph, v, st, visited);
			}
		}
		st.add(src);

	}

	public static void dfs2(ArrayList<Integer>[] ngraph, int src, boolean[] visited) {
		visited[src] = true;
		for (int v : ngraph[src]) {
			if (visited[v] == false) {
				dfs2(ngraph, v, visited);
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
			int v1 = Integer.parseInt(parts[0]);
			int v2 = Integer.parseInt(parts[1]);
			graph[v1 - 1].add(v2 - 1);
		}

		// step 1:- random order dfs(stack add before backtrack)
		boolean[] visited = new boolean[n];
		Stack<Integer> st = new Stack<>();
		for (int i = 0; i < n; i++) {
			if (visited[i] == false) {
				dfs1(graph, i, st, visited);
			}
		}

		// step 2:- reverse all the edges
		ArrayList<Integer>[] ngraph = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			ngraph[i] = new ArrayList<>();
		}

		for (int i = 0; i < n; i++) {
			for (int v : graph[i]) {
				ngraph[v].add(i);
			}
		}

		// step 3:- do dfs in the order arranged in stack

		int ans = 0;
		visited = new boolean[n];
		while (st.size() > 0) {
			int rem = st.pop();
			if (visited[rem] == false) {
				dfs2(ngraph, rem, visited);
				ans++;
			}
		}

		System.out.println(ans);

	}

}
