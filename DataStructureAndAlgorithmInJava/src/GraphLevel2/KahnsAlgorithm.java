package GraphLevel2;

import java.util.*;
import java.io.*;

/*
i/p->
6
6
0 2
1 2
0 3
3 4
4 5
1 5

o/p->
[0, 1, 3, 2, 4, 5]

*/

public class KahnsAlgorithm {

	static class Edge {
		int src;
		int nbr;

		Edge(int src, int nbr) {
			this.src = src;
			this.nbr = nbr;
		}
	}

	static ArrayList<Integer> fun(int n, ArrayList<Edge>[] graph) {
		int[] indegree = new int[n];
		ArrayList<Integer> ans = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			for (Edge e : graph[i]) {
				indegree[e.nbr] = indegree[e.nbr] + 1;
			}
		}

		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			if (indegree[i] == 0) {
				q.add(i);
			}
		}

		while (q.size() > 0) {
			int rem = q.poll();
			ans.add(rem);
			for (Edge e : graph[rem]) {
				indegree[e.nbr]--;
				if (indegree[e.nbr] == 0) {
					q.add(e.nbr);
				}
			}
		}

		if (ans.size() == n) {
			return ans;
		} else {
			ArrayList<Integer> x = new ArrayList<>();
			x.add(-1);
			return x;
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

		ArrayList<Integer> ans = fun(n, graph);
		System.out.println(ans);

	}

}
