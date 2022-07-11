package Array;

//Largest Sum Contiguous Subarray
//6
public class Kadane {

	public static void main(String[] args) {
		int[] arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		int n = arr.length;
		int max_so_far = Integer.MIN_VALUE;
		int curr_max = 0;

		for (int i = 0; i < n; i++) {
			curr_max = curr_max + arr[i];
			if (max_so_far < curr_max) {
				max_so_far = curr_max;
			}
			if (curr_max < 0) {
				curr_max = 0;
			}
		}
		System.out.println(max_so_far);

	}

}
