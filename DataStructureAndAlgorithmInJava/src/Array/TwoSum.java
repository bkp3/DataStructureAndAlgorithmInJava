package Array;

import java.util.HashMap;

//1 0
public class TwoSum {

	public static void main(String[] args) {
		int[] arr = { 2, 7, 11, 15 };
		int target = 9;
		int n = arr.length;

		HashMap<Integer, Integer> mp = new HashMap<>();
		int x = 0, y = 0;
		for (int i = 0; i < n; i++) {
			if (mp.containsKey(target - arr[i])) {
				x = i;
				y = mp.get(target - arr[i]);
				break;
			} else {
				mp.put(arr[i], i);
			}
		}
		System.out.println(x + " " + y);
	}

}
