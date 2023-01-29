package Array;

import java.util.*;

/*
[1]
[1, 2]
[1, 2, 3]
[1, 2, 3, 4]
[1, 2, 3, 4, 5]
[2]
[2, 3]
[2, 3, 4]
[2, 3, 4, 5]
[3]
[3, 4]
[3, 4, 5]
[4]
[4, 5]
[5]

*/
public class SubArray {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5 };
		ArrayList<ArrayList<Integer>> al = new ArrayList<>();
		int n = arr.length;

		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				ArrayList<Integer> temp = new ArrayList<>();
				for (int k = i; k <= j; k++) {
					temp.add(arr[k]);
				}
				al.add(temp);
			}
		}
		for (ArrayList<Integer> x : al) {
			System.out.println(x);
		}

	}

}
