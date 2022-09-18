package ArrayMust;

// output = 4

public class MissingNumber {

	public static void main(String[] args) {

		int[] arr = { 1, 2, 3, 5 };
		int n = 5;

		int sum = (n * (n + 1)) / 2;

		int arrSum = 0;
		for (int i = 0; i < n - 1; i++) {
			arrSum = arrSum + arr[i];
		}
		int ans = sum - arrSum;
		System.out.println(ans);

	}

}
