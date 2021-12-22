package StringZone;

import java.util.*;

//Total possible subsets for string of size n is n*(n+1)/2

public class SubsetOfString {

	public static void main(String[] args) {

		String str = "student";

		int n = str.length();

		ArrayList<String> arr = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				arr.add(str.substring(i, j + 1));
			}
		}

		for (String x : arr) {
			System.out.println(x);
		}

	}

}
