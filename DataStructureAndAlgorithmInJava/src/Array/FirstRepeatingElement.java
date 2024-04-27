package Array;

import java.util.HashSet;
//5

public class FirstRepeatingElement {

	public static void main(String[] args) {
		int[] arr = { 10, 5, 3, 4, 3, 5, 6 };
		int n = arr.length;
		int min = -1;
		HashSet<Integer> set = new HashSet<>();
		for (int i = n - 1; i >= 0; i--) {
			if (set.contains(arr[i])) {
				min = i;
			} else {
				set.add(arr[i]);
			}
		}
		if (min != -1) {
			System.out.println(arr[min]);
		} else {
			System.out.println("no repeating element");
		}

	}

}
