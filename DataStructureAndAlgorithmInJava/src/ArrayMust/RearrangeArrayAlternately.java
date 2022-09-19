package ArrayMust;

//6 1 5 2 4 3 

public class RearrangeArrayAlternately {

	public static void main(String[] args) {
		int n = 6;
		int[] arr = { 1, 2, 3, 4, 5, 6 };

		int min_index = 0;
		int max_index = n - 1;
		int max_element = arr[max_index] + 1;

		for (int i = 0; i < n; i++) {
			if (i % 2 == 0) {
				arr[i] = arr[i] + (arr[max_index] % max_element) * max_element;
				max_index--;
			} else {
				arr[i] = arr[i] + (arr[min_index] % max_element) * max_element;
				min_index++;
			}
		}
		for (int i = 0; i < n; i++) {
			arr[i] = arr[i] / max_element;
		}

		for (int x : arr) {
			System.out.print(x + " ");
		}

	}

}
