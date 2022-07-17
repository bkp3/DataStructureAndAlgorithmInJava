package ArrayMust;

import java.util.Arrays;
//9743412

public class LargestNumberFormedFromArray {

	public static void main(String[] args) {
		String[] arr = { "12", "34", "74", "9" };
		Arrays.sort(arr, (a, b) -> (b + a).compareTo(a + b));
		String ans = String.join("", arr);
		System.out.println(ans);

	}

}
