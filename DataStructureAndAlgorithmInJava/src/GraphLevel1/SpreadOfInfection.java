package GraphLevel1;

import java.util.*;
import java.io.*;

/*
i/p->
7
8
0 1
1 2
2 3
3 0
3 4
4 5
5 6
4 6
6
3

o/p->
4


*/
public class SpreadOfInfection {

	static class Edge {
		int src;
		int nbr;

		Edge(int src, int nbr) {
			this.src = src;
			this.nbr = nbr;
		}
	}

	static class Pair {
		int v;
		int t;

		Pair(int v, int t) {
			this.v = v;
			this.t = t;
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
			graph[src].add(new Edge(src, nbr));
			graph[nbr].add(new Edge(nbr, src));
		}

		int source = Integer.parseInt(br.readLine());
		int t = Integer.parseInt(br.readLine());

		ArrayDeque<Pair> q = new ArrayDeque<>();
		q.add(new Pair(source, 1));
		int[] visited = new int[n];
		int count = 0;

		while (q.size() > 0) {
			// rm*wa*
			Pair rem = q.removeFirst();

			if (visited[rem.v] > 0) {
				continue;

			}
			visited[rem.v] = rem.t;

			if (rem.t > t) {
				break;
			}

			count++;

			for (Edge edge : graph[rem.v]) {
				if (visited[edge.nbr] == 0) {
					q.add(new Pair(edge.nbr, rem.t + 1));
				}
			}

		}
		System.out.println(count);

	}

}
