package GraphLevel2;

import java.util.*;
import java.io.*;

/*
based on prims(MST)

i/p->
7
8
0 1 10
1 2 10
2 3 10
0 3 40
3 4 2
4 5 3
5 6 3
6 4 8

o/p->
38


*/

public class ConnectingCitiesWithMinimumCost {

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

	static class Pair implements Comparable<Pair> {
		int v;
		int av;
		int wt;

		Pair(int v, int av, int wt) {
			this.v = v;
			this.av = av;
			this.wt = wt;
		}

		@Override
		public int compareTo(Pair o) {
			return this.wt - o.wt;
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
			int wt = Integer.parseInt(parts[2]);
			graph[v1].add(new Edge(v1, v2, wt));
			graph[v2].add(new Edge(v2, v1, wt));
		}

		int ans = 0;

		PriorityQueue<Pair> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[n];
		pq.add(new Pair(0, -1, 0));

		while (pq.size() > 0) {
			// rm*wa*;
			Pair rem = pq.remove();

			if (visited[rem.v] == true) {
				continue;
			}
			visited[rem.v] = true;

			ans = ans + rem.wt;

			for (Edge edge : graph[rem.v]) {
				if (visited[edge.nbr] == false) {
					pq.add(new Pair(edge.nbr, rem.v, edge.wt));
				}
			}
		}

		System.out.println(ans);

	}

}
