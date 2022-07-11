package ArrayMust;

import java.util.*;

//2
public class CountTheTriplets {

	public static void main(String[] args) {

		int[] arr = { 1, 5, 3, 2 };
		int n = arr.length;

		HashMap<Integer, Integer> mp = new HashMap<>();

		for (int i = 0; i < n; i++) {
			mp.put(arr[i], 1);
		}
		int count = 0;
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				if (mp.containsKey(arr[i] + arr[j])) {
					count++;
				}
			}
		}
		System.out.println(count);

	}

}
