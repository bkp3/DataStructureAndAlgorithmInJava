package Array;

import java.util.*;

/*
output:-
[[1], [1, 1], [1, 2, 1], [1, 3, 3, 1]]
*/
public class PascalTriangle {

	public static void main(String[] args) {
		int n = 4;
		ArrayList<ArrayList<Integer>> arr = new ArrayList<>();

		for (int i = 1; i <= n; i++) {
			ArrayList<Integer> al = new ArrayList<>();
			int C = 1;
			for (int j = 1; j <= i; j++) {
				al.add(C);
				C = C * (i - j) / j;
			}
			arr.add(al);
		}
		System.out.println(arr);

	}

}
