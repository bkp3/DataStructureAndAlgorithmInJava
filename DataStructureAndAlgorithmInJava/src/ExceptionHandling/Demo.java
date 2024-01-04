package ExceptionHandling;

import java.util.ArrayList;
import java.util.HashSet;

public class Demo {

	public static void main(String[] args) {
		//int[] arr = { 1, 3, 0, 0, 2, 0, 0, 4 };// 6
		int[] arr = { 1, 3, 0, 0, 0, 2, 0, 0, 4 };// 8

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
		System.out.println("--------------------------------------");
		int count = 0;
		for (ArrayList<Integer> x : al) {
			int flag = 0;
			for (int y : x) {
				if (y != 0) {
					flag = 1;
				}
			}
			if (flag == 0) {
				count++;
				System.out.println(x);
			}
		}
		System.out.println(count);

	}

}
