package Array;

import java.util.*;

/*
[1]
[2]
[1, 2]
[3]
[1, 3]
[2, 3]
[1, 2, 3]
[4]
[1, 4]
[2, 4]
[1, 2, 4]
[3, 4]
[1, 3, 4]
[2, 3, 4]
[1, 2, 3, 4]
[5]
[1, 5]
[2, 5]
[1, 2, 5]
[3, 5]
[1, 3, 5]
[2, 3, 5]
[1, 2, 3, 5]
[4, 5]
[1, 4, 5]
[2, 4, 5]
[1, 2, 4, 5]
[3, 4, 5]
[1, 3, 4, 5]
[2, 3, 4, 5]
[1, 2, 3, 4, 5]


*/
public class SubsequenceOfArray {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5 };
		ArrayList<ArrayList<Integer>> al = new ArrayList<>();
		int n = arr.length;
		int len = (int) Math.pow(2, n);
		for (int i = 1; i <= len - 1; i++) {
			ArrayList<Integer> tmp = new ArrayList<>();
			for (int j = 0; j < n; j++) {
				if ((i & (1 << j)) != 0) {
					tmp.add(arr[j]);
				}
			}
			al.add(tmp);

		}
		for (ArrayList<Integer> x : al) {
			System.out.println(x);
		}
	}

}
