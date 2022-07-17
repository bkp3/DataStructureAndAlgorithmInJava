package SearchAlgo;

import java.util.*;

//Element founds at index 3
public class BinarySearchAlgo {

	public static int binarySearch(int[] arr, int key) {
		int n = arr.length;
		int low = 0;
		int high = n - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (arr[mid] == key) {
				return mid;
			}
			if (key < arr[mid]) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
		int x = 4;
		int pos = binarySearch(arr, x);

		if (pos != -1) {
			System.out.println("Element founds at index " + pos);
		} else {
			System.out.println("Element not found.");
		}

	}

}
