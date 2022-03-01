package Array;

public class BinarySearch {

	static int binarySearch(int[] arr, int target) {
		int l = 0, r = arr.length - 1;
		while (l <= r) {
			int mid = l + (r - l) / 2;
			if (arr[mid] == target)
				return mid;
			if (arr[mid] < target)
				l = mid + 1;
			else
				r = mid - 1;
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8 };
		int target = 4;
		int ans = binarySearch(arr, target);
		System.out.println(ans);

	}

}
