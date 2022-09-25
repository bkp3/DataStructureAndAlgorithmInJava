package ArrayMust;

import java.util.ArrayList;
import java.util.Collections;
//[17, 5, 2]

public class LeadersInArray {

	public static void main(String[] args) {

		int n = 6;
		int[] arr = { 16, 17, 4, 3, 5, 2 };

		ArrayList<Integer> ans = new ArrayList();

		int max = arr[n - 1];
		ans.add(max);
		for (int i = n - 2; i >= 0; i--) {
			if (arr[i] >= max) {
				max = arr[i];
				ans.add(max);
			}
		}
		Collections.reverse(ans);
		System.out.println(ans);

	}

}
