
public class SecondLargestNumber {

	public static void main(String[] args) {
		int[] arr = { 4, 2, 5, 7, 9, 5, 2, 8 };
		int n = arr.length;
		int first = Integer.MIN_VALUE;
		int second = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			if (first < arr[i]) {
				second = first;
				first = arr[i];
			} else if (second < arr[i] && first != arr[i]) {
				second = arr[i];
			}
		}

		System.out.println(first + "--" + second);

	}

}
