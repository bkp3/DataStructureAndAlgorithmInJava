package SortingAlgo;

/*
2 
3 
4 
5 
6 
7 
8 
9 

*/
public class MergeSort {

	static void merge(int[] arr, int l, int mid, int r) {

		int n1 = mid - l + 1;
		int n2 = r - mid;

		int[] L = new int[n1];
		int[] R = new int[n2];
		for (int i = 0; i < n1; i++) {
			L[i] = arr[l + i];
		}
		for (int j = 0; j < n2; j++) {
			R[j] = arr[mid + 1 + j];
		}

		int i = 0;
		int j = 0;
		int k = l;
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				arr[k] = L[i];
				i++;
			} else {
				arr[k] = R[j];
				j++;
			}
			k++;
		}

		while (i < n1) {
			arr[k] = L[i];
			i++;
			k++;
		}

		while (j < n2) {
			arr[k] = R[j];
			j++;
			k++;
		}

	}

	static void mergeSort(int[] arr, int l, int h) {
		if (l < h) {
			int mid = (l + h) / 2;
			mergeSort(arr, l, mid);
			mergeSort(arr, mid + 1, h);
			merge(arr, l, mid, h);
		}
	}

	public static void main(String[] args) {
		int[] arr = { 9, 3, 7, 5, 6, 4, 8, 2 };
		int n = arr.length;
		mergeSort(arr, 0, n - 1);
		for (int x : arr) {
			System.out.println(x + " ");
		}

	}

}
