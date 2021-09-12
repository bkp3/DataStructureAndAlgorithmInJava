package GraphLevel2;

import java.util.*;
import java.io.*;
/*
Based on MST(Prims)
i/p->
3
2
1 2 2
1 2 1
2 3 1

o/p->
0 - -1 @ 0
3 - 0 @ 1
1 - 3 @ 1
2 - 1 @ 2
Total :- 4

i/p->
5
6
1 2 2
2 3 4
3 5 7
5 2 14
2 4 8
1 4 12
3 9 12 10 6

o/p->
0 - -1 @ 0
1 - 0 @ 3
2 - 1 @ 2
3 - 2 @ 4
5 - 0 @ 6
4 - 2 @ 8
Total :- 23
*/

public class OptimizeWaterDistribution {

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
		int m = Integer.parseInt(br.readLine());

		ArrayList<Edge>[] graph = new ArrayList[n + 1];
		for (int i = 0; i < n + 1; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			String[] parts = br.readLine().split(" ");
			int v1 = Integer.parseInt(parts[0]);
			int v2 = Integer.parseInt(parts[1]);
			int wt = Integer.parseInt(parts[2]);
			graph[v1].add(new Edge(v1, v2, wt));
			graph[v2].add(new Edge(v2, v1, wt));
		}

		int[] wells = new int[n];
		String[] str = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			wells[i] = Integer.parseInt(str[i]);
		}

		for (int i = 0; i < n; i++) {
			graph[0].add(new Edge(0, i + 1, wells[i]));
			graph[i + 1].add(new Edge(i + 1, 0, wells[i]));
		}

		PriorityQueue<Pair> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[n + 1];
		pq.add(new Pair(0, -1, 0));
		int ans = 0;
		while (pq.size() > 0) {
			// rm*wa*
			Pair rem = pq.remove();

			if (visited[rem.v] == true) {
				continue;
			}
			visited[rem.v] = true;

			System.out.println(rem.v + " - " + rem.av + " @ " + rem.wt);
			ans = ans + rem.wt;

			for (Edge e : graph[rem.v]) {
				if (visited[e.nbr] == false) {
					pq.add(new Pair(e.nbr, rem.v, e.wt));
				}
			}
		}

		System.out.println("Total :- " + ans);

	}

}
