package GraphLevel1;

import java.io.*;
import java.util.*;

/*
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
1-0 @ 10
2-1 @ 10
3-2 @ 10
4-3 @ 2
5-4 @ 3
6-5 @ 3


*/
// Minimum Spanning Tree(MST)
public class PrimsAlgorithm {

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
		// acquring vertex
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
			int src = Integer.parseInt(parts[0]);
			int nbr = Integer.parseInt(parts[1]);
			int wt = Integer.parseInt(parts[2]);
			graph[src].add(new Edge(src, nbr, wt));
			graph[nbr].add(new Edge(nbr, src, wt));
		}

		PriorityQueue<Pair> pq = new PriorityQueue<>();
		pq.add(new Pair(0, -1, 0));
		boolean[] visited = new boolean[n];

		while (pq.size() > 0) {
			// rm*wa*

			Pair rem = pq.remove();

			if (visited[rem.v] == true) {
				continue;
			}
			visited[rem.v] = true;

			if (rem.av != -1)
				System.out.println(rem.v + "-" + rem.av + " @ " + rem.wt);

			for (Edge edge : graph[rem.v]) {
				if (visited[edge.nbr] == false) {
					pq.add(new Pair(edge.nbr, rem.v, edge.wt));
				}
			}
		}

	}

}
