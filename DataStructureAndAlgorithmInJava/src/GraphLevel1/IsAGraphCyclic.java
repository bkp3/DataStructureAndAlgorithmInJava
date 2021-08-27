package GraphLevel1;

import java.util.*;
import java.io.*;

/*

i/p->
7
5
0 1 10
2 3 10
4 5 10
5 6 10
4 6 10

o/p->


*/
public class IsAGraphCyclic {

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

	static class Pair {
		int v;
		String psf;

		Pair(int v, String psf) {
			this.v = v;
			this.psf = psf;
		}
	}

	public static boolean isCyclic(ArrayList<Edge>[] graph, int src, boolean[] visited) {
		ArrayDeque<Pair> queue = new ArrayDeque<>();
		queue.add(new Pair(src, src + ""));

		while (queue.size() > 0) {
			// rm*wa*
			// remove mark * work add *

			Pair rem = queue.removeFirst();
			if (visited[rem.v] == true) {
				return true;
			}
			visited[rem.v] = true;
			for (Edge edge : graph[rem.v]) {
				if (visited[edge.nbr] == false) {
					queue.add(new Pair(edge.nbr, rem.psf + edge.nbr));
				}
			}
		}
		return false;
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

		boolean[] visited = new boolean[n];
		for (int i = 0; i < n; i++) {
			if (visited[i] == false) {
				boolean cycle = isCyclic(graph, i, visited);
				if (cycle) {
					System.out.println(true);
					return;
				}

			}
		}
		System.out.println(false);

	}

}
