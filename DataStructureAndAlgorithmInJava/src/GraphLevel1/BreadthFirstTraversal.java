package GraphLevel1;

import java.util.*;
import java.io.*;
/*
i/p ->
7
8
0 3
0 1
1 2
3 2
5 6
4 5
4 6
3 4
2

o/p ->

2@2
1@21
3@23
0@210
4@234
5@2345
6@2346
*/

public class BreadthFirstTraversal {

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
		String psf;

		Pair(int v, String psf) {
			this.v = v;
			this.psf = psf;
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
			graph[v2].add(new Edge(v2, v1));
		}

		int src = Integer.parseInt(br.readLine());

		ArrayDeque<Pair> queue = new ArrayDeque<>();
		queue.add(new Pair(src, src + ""));
		boolean[] visited = new boolean[n];

		while (queue.size() > 0) {
			// r m* w a*
			// remove mark * work a *
			Pair rem = queue.removeFirst();
			if (visited[rem.v] == true) {
				continue;
			}

			visited[rem.v] = true;

			System.out.println(rem.v + "@" + rem.psf);

			for (Edge edge : graph[rem.v]) {
				if (visited[edge.nbr] == false) {
					queue.add(new Pair(edge.nbr, rem.psf + edge.nbr));
				}
			}
		}

	}

}
