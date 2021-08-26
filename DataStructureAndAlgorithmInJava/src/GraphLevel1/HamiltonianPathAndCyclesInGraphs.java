package GraphLevel1;

import java.util.*;
import java.io.*;

/*
i/p->

7
9
0 1 10
1 2 10
2 3 10
0 3 10
3 4 10
4 5 10
5 6 10
4 6 10
2 5 10
0

o/p ->
0123456 cycle is not present
0123465 cycle is not present
0125643 cycle is present
0346521 cycle is present

*/

public class HamiltonianPathAndCyclesInGraphs {

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

	static void hamiltonian(ArrayList<Edge>[] graph, int src, HashSet<Integer> visited, String psf, int osrc) {

		if (visited.size() == graph.length - 1) {
			System.out.print(psf + " ");
			boolean closingEdgeFound = false;
			for (Edge e : graph[src]) {
				if (e.nbr == osrc) {
					closingEdgeFound = true;
					break;
				}
			}
			if (closingEdgeFound == true) {
				System.out.println("cycle is present");
			} else {
				System.out.println("cycle is not present");
			}

		}

		visited.add(src);
		for (Edge e : graph[src]) {
			if (visited.contains(e.nbr) == false) {
				hamiltonian(graph, e.nbr, visited, psf + e.nbr, osrc);
			}
		}
		visited.remove(src);
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

		int src = Integer.parseInt(br.readLine());
		HashSet<Integer> visited = new HashSet<>();
		hamiltonian(graph, src, visited, src + "", src);

	}

}
