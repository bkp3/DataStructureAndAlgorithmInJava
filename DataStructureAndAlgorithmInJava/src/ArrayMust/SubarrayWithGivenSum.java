package ArrayMust;

import java.util.*;
//[1, 3]

public class SubarrayWithGivenSum {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 7, 5 };
		int s = 12;
		int n = arr.length;

		ArrayList<Integer> ans = new ArrayList<>();
		HashMap<Integer, Integer> mp = new HashMap<>();
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum = sum + arr[i];
			if (sum == s) {
				ans.add(0);
				ans.add(i);
				break;
			}
			if (mp.containsKey(sum - s)) {

				ans.add(mp.get(sum - s) + 1);
				ans.add(i);
				break;
			} else {
				mp.put(sum, i);
			}
		}
		if (ans.size() == 0) {
			ans.add(-1);
		}
		System.out.println(ans);

	}

}
