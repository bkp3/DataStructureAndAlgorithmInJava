package ArrayMust;

import java.util.Arrays;

/*

0 1 2 3 
5 6 7 8 9 
*/
public class MergeTwoSortedArrays {

	public static void main(String[] args) {
		int n = 4;
		int[] arr1 = { 1, 3, 5, 7 };

		int m = 5;
		int[] arr2 = { 0, 2, 6, 8, 9 };

		int i = 0;
		int j = 0;
		int k = n - 1;

		while (i <= k && j < m) {
			if (arr1[i] < arr2[j]) {
				i++;
			} else {
				int temp = arr1[k];
				arr1[k] = arr2[j];
				arr2[j] = temp;
				j++;
				k--;
			}
		}
		Arrays.sort(arr1);
		Arrays.sort(arr2);

		for (int x : arr1) {
			System.out.print(x + " ");
		}
		System.out.println();
		for (int x : arr2) {
			System.out.print(x + " ");
		}

	}

}
