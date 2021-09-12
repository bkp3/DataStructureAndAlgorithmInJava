package GraphLevel2;

import java.util.*;
import java.io.*;

/*
i/p->
4
3
1 2 3
1 4 5
5 8 7
3 6 7
1
7

o/p->
2

*/

public class BusRoutes {

	static int numBusesToDest(int[][] mat, int S, int T) {

		HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				if (map.containsKey(mat[i][j])) {
					ArrayList<Integer> arr1 = map.get(mat[i][j]);
					arr1.add(i);
					map.put(mat[i][j], arr1);
				} else {
					ArrayList<Integer> arr2 = new ArrayList<>();
					arr2.add(i);
					map.put(mat[i][j], arr2);
				}
			}
		}

		Queue<Integer> q = new LinkedList<>();
		HashSet<Integer> busstopvis = new HashSet<>();
		HashSet<Integer> busvis = new HashSet<>();

		int level = 0;
		q.add(S);
		busstopvis.add(S);

		while (q.size() > 0) {
			int size = q.size();
			while (size-- > 0) {
				int rem = q.remove();

				if (rem == T) {
					return level;
				}

				ArrayList<Integer> buses = map.get(rem);
				for (int bus : buses) {
					if (busvis.contains(bus) == false) {
						int[] arr = mat[bus];
						for (int busstoop : arr) {
							if (busstopvis.contains(busstoop) == false) {
								q.add(busstoop);
								busstopvis.add(busstoop);
							}
						}
						busvis.add(bus);
					}
				}
			}
			level++;
		}
		return -1;

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		int[][] mat = new int[n][m];

		for (int i = 0; i < n; i++) {
			String[] parts = br.readLine().split(" ");
			for (int j = 0; j < m; j++) {
				mat[i][j] = Integer.parseInt(parts[j]);
			}
		}

		int src = Integer.parseInt(br.readLine());
		int dest = Integer.parseInt(br.readLine());

		int ans = numBusesToDest(mat, src, dest);
		System.out.println(ans);

	}

}
