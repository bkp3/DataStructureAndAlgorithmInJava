package ArrayMust;
//3

public class EquilibriumPoint {

	static int fun(int[] arr, int n) {
		if (n == 1) {
			return 1;
		}
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum = sum + arr[i];
		}
		int leftSum = 0;
		for (int i = 0; i < n; i++) {
			sum = sum - arr[i];
			if (leftSum == sum) {
				return i + 1;
			}
			leftSum = leftSum + arr[i];
		}
		return -1;
	}

	public static void main(String[] args) {
		int n = 5;
		int arr[] = { 1, 3, 5, 2, 2 };

		int ans = fun(arr, n);
		System.out.println(ans);

	}

}
