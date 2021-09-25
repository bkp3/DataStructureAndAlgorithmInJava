package GraphSelf;

import java.io.*;
import java.util.*;

//using BFS
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
true

*/

public class IsAGraphCyclic {

	static boolean isCyclic(ArrayList<Integer>[] adj, int src, boolean[] visited) {
		Queue<Integer> q = new LinkedList<>();
		q.add(src);
		while (q.size() > 0) {
			int rem = q.remove();

			if (visited[rem] == true) {
				return true;
			}
			visited[rem] = true;

			for (int x : adj[rem]) {
				if (visited[x] == false) {
					q.add(x);
				}
			}
		}
		return false;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int e = Integer.parseInt(br.readLine());

		ArrayList<Integer>[] adj = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			adj[i] = new ArrayList<>();
		}

		for (int i = 0; i < e; i++) {
			String[] parts = br.readLine().split(" ");
			int v1 = Integer.parseInt(parts[0]);
			int v2 = Integer.parseInt(parts[1]);
			adj[v1].add(v2);
			adj[v2].add(v1);
		}

		boolean[] visited = new boolean[n];
		for (int i = 0; i < n; i++) {
			if (visited[i] == false) {
				boolean cycle = isCyclic(adj, i, visited);
				if (cycle == true) {
					System.out.println(true);
					return;
				}
			}
		}
		System.out.println(false);

	}

}
