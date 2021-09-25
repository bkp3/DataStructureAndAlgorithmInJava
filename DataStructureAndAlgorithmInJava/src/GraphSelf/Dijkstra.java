package GraphSelf;

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
0

o/p->

0 - 0 @ 0
1 - 01 @ 10
2 - 012 @ 20
3 - 0123 @ 30
4 - 01234 @ 32
5 - 012345 @ 35
6 - 0123456 @ 38

2nd example:-
i/p->
5
6
0 1 9
0 2 6
0 3 5
0 4 3
2 1 2
2 3 4
0

o/p->
0 - 0 @ 0
4 - 04 @ 3
3 - 03 @ 5
2 - 02 @ 6
1 - 021 @ 8

*/
public class Dijkstra {

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
		String psf;
		int wsf;

		Pair(int v, String psf, int wsf) {
			this.v = v;
			this.psf = psf;
			this.wsf = wsf;
		}

		@Override
		public int compareTo(Pair o) {
			return this.wsf - o.wsf;
		}
	}

	static void dijkstra(ArrayList<Edge>[] adj, int src, boolean[] visited) {
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		pq.add(new Pair(src, src + "", 0));
		while (pq.size() > 0) {
			// rm*wa*
			Pair rem = pq.remove();

			if (visited[rem.v] == true) {
				continue;
			}
			visited[rem.v] = true;

			System.out.println(rem.v + " - " + rem.psf + " @ " + rem.wsf);
			// dist[rem.v]=rem.wsf;

			for (Edge e : adj[rem.v]) {
				if (visited[e.nbr] == false) {
					pq.add(new Pair(e.nbr, rem.psf + e.nbr, rem.wsf + e.wt));
				}
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
			int v1 = Integer.parseInt(parts[0]);
			int v2 = Integer.parseInt(parts[1]);
			int wt = Integer.parseInt(parts[2]);
			adj[v1].add(new Edge(v1, v2, wt));
			adj[v2].add(new Edge(v2, v1, wt));
		}

		int src = Integer.parseInt(br.readLine());

		boolean[] visited = new boolean[n];
		dijkstra(adj, src, visited);

	}

}
