package HashMapAndHeap;

import java.util.*;
/*
i/p->
7
7
1 1 2 2 2 3 5
1 1 1 2 2 4 5

o/p->


*/

public class GetCommonElementTwo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n1 = sc.nextInt();
		int n2 = sc.nextInt();

		ArrayList<Integer> arr1 = new ArrayList<>();
		ArrayList<Integer> arr2 = new ArrayList<>();

		for (int i = 0; i < n1; i++) {
			int x = sc.nextInt();
			arr1.add(x);
		}
		for (int i = 0; i < n2; i++) {
			int x = sc.nextInt();
			arr2.add(x);
		}

		HashMap<Integer, Integer> hm = new HashMap<>();
		for (int i = 0; i < n1; i++) {
			if (hm.containsKey(arr1.get(i))) {
				int x = hm.get(arr1.get(i));
				x++;
				hm.put(arr1.get(i), x);
			} else {
				hm.put(arr1.get(i), 1);
			}
		}

		ArrayList<Integer> ans = new ArrayList<>();
		for (int i = 0; i < n2; i++) {
			if (hm.containsKey(arr2.get(i)) && hm.get(arr2.get(i)) > 0) {
				ans.add(arr2.get(i));
				int x = hm.get(arr2.get(i));
				x = x - 1;
				hm.put(arr2.get(i), x);
			}
		}

		System.out.println(ans);

	}

}
