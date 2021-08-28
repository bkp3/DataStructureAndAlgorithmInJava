package GraphLevel1;

import java.util.*;
import java.io.*;

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

0 via 0 @ 0
1 via 01 @ 10
2 via 012 @ 20
3 via 0123 @ 30
4 via 01234 @ 32
5 via 012345 @ 35
6 via 0123456 @ 38

*/

public class DijkstraAlgorithm {

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

		int source = Integer.parseInt(br.readLine());

		PriorityQueue<Pair> pq = new PriorityQueue<>();
		pq.add(new Pair(source, source + "", 0));
		boolean[] visited = new boolean[n];

		while (pq.size() > 0) {
			// rm*wa*

			// remove
			Pair rem = pq.remove();

			// mark *
			if (visited[rem.v] == true) {
				continue;
			}
			visited[rem.v] = true;

			// work
			System.out.println(rem.v + " via " + rem.psf + " @ " + rem.wsf);

			// add *
			for (Edge edge : graph[rem.v]) {
				if (visited[edge.nbr] == false) {
					pq.add(new Pair(edge.nbr, rem.psf + edge.nbr, rem.wsf + edge.wt));
				}
			}
		}

	}

}
