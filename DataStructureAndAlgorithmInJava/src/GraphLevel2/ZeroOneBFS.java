package GraphLevel2;

import java.util.*;
import java.io.*;

/*
i/p->
7
7
0 1
2 1
2 3
6 3
6 4
4 5
5 1

o/p->
2


*/

public class ZeroOneBFS {

	static class Pair {
		int dst;
		int wt;

		Pair(int dst, int wt) {
			this.dst = dst;
			this.wt = wt;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int e = Integer.parseInt(br.readLine());

		ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < e; i++) {
			String[] parts = br.readLine().split(" ");
			int u = Integer.parseInt(parts[0]);
			int v = Integer.parseInt(parts[1]);

			graph.get(u).add(new Pair(v, 0));
			graph.get(v).add(new Pair(u, 1));
		}

		LinkedList<Pair> q = new LinkedList<>();
		boolean[] visited = new boolean[n];
		q.addLast(new Pair(0, 0));

		while (q.size() > 0) {
			Pair rem = q.removeFirst();

			if (rem.dst == n - 1) {
				System.out.println(rem.wt);
				return;
			}

			visited[rem.dst] = true;

			for (Pair p : graph.get(rem.dst)) {
				if (visited[p.dst] == false) {
					if (p.wt == 0) {
						q.addFirst(new Pair(p.dst, rem.wt + 0));
					} else {
						q.addLast(new Pair(p.dst, rem.wt + 1));
					}
				}
			}
		}

		System.out.println("-1");

	}

}
