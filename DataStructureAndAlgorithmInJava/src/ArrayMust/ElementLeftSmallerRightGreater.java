package ArrayMust;

//-1
public class ElementLeftSmallerRightGreater {

	static int fun(int[] arr, int n) {
		int l_max = arr[0];
		int r_min = Integer.MAX_VALUE;
		int minFromRight[] = new int[n];

		for (int i = n - 1; i >= 0; i--) {
			if (arr[i] < r_min) {
				r_min = arr[i];
			}
			minFromRight[i] = r_min;
		}
		for (int i = 1; i < n - 1; ++i) {
			if (arr[i] >= l_max) {
				l_max = arr[i];
				if (arr[i] <= minFromRight[i + 1]) {
					return arr[i];
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int n = 14;
		int[] arr = { 5, 6, 4, 1, 7, 12, 9, 1, 4, 1, 11, 5, 7, 1 };

		int ans = fun(arr, n);
		System.out.println(ans);

	}

}
