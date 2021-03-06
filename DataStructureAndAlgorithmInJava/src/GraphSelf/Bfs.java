package GraphSelf;

import java.util.*;
import java.io.*;
/*
i/p->
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

o/p->
2
1
3
0
4
5
6

*/

public class Bfs {
	static void bfs(ArrayList<Integer>[] adj, int src, boolean[] visited) {
		Queue<Integer> q = new LinkedList<>();
		q.add(src);
		while (q.size() > 0) {
			int rem = q.remove();

			if (visited[rem] == true) {
				continue;
			}
			visited[rem] = true;

			System.out.println(rem);

			for (int x : adj[rem]) {
				if (visited[x] == false) {
					q.add(x);
				}
			}
		}
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

		int src = Integer.parseInt(br.readLine());
		boolean[] visited = new boolean[n];
		bfs(adj, src, visited);

	}

}
