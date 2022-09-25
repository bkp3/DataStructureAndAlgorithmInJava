package ArrayMust;

import java.util.*;

public class ReverseInGroup {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n = 5, k = 3;
		ArrayList<Integer> arr = new ArrayList<>();
		arr.add(1);
		arr.add(2);
		arr.add(3);
		arr.add(4);
		arr.add(5);

		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

		ArrayList<Integer> temp = new ArrayList<>();
		int count = 0;
		for (int i = 0; i < k * (n / k); i++) {
			temp.add(arr.get(i));
			count++;
			if (count == k) {
				Collections.reverse(temp);
				ans.add(temp);
				temp = new ArrayList<>();
				count = 0;
			}
		}
		temp.clear();
		for (int i = (k * (n / k)); i < n; i++) {
			temp.add(arr.get(i));
		}
		Collections.reverse(temp);
		ans.add(temp);
		arr = new ArrayList<>();
		for (ArrayList<Integer> x : ans) {
			for (int y : x) {
				arr.add(y);
			}
		}
		System.out.println(arr);

	}

}
