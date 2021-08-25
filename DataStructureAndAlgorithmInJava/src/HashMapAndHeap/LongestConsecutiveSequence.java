package HashMapAndHeap;

import java.util.*;

/*
i/p->
11
10 5 9 1 11 8 6 15 3 12 2

o/p->
8
9
10
11
12


*/
public class LongestConsecutiveSequence {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Integer> arr = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			int x = sc.nextInt();
			arr.add(x);
		}

		HashMap<Integer, Boolean> hm = new HashMap<>();

		for (int val : arr) {
			hm.put(val, true);
		}

		for (int val : arr) {
			if (hm.containsKey(val - 1)) {
				hm.put(val, false);
			}
		}

		int msp = 0;
		int ml = 0;

		for (int val : arr) {
			if (hm.get(val) == true) {
				int tl = 1;
				int tsp = val;
				while (hm.containsKey(tsp + tl)) {
					tl++;
				}
				if (tl > ml) {
					msp = tsp;
					ml = tl;
				}
			}
		}

		for (int i = 0; i < ml; i++) {
			System.out.println(msp + i);
		}

	}

}
