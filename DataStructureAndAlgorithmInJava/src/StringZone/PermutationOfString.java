package StringZone;

import java.util.*;

/*

[abcd, abdc, acbd, acdb, adbc, adcb, bacd, badc, bcad, bcda, bdac, bdca, cabd, cadb, cbad, cbda, cdab, cdba, dabc, dacb, dbac, dbca, dcab, dcba]
24


*/

public class PermutationOfString {

	static void printPermutn(ArrayList<String> arr, String str, String ans) {

		if (str.length() == 0) {
			// System.out.print(ans + " ");
			arr.add(ans);
			return;
		}

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			String ros = str.substring(0, i) + str.substring(i + 1);
			printPermutn(arr, ros, ans + ch);
		}
	}

	public static void main(String[] args) {
		String str = "abcd";

		int n = str.length();

		ArrayList<String> arr = new ArrayList<>();

		printPermutn(arr, str, "");
		System.out.println(arr);
		System.out.println(arr.size());

	}

}
