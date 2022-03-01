package Array;

//Largest Sum Contiguous Subarray
//6
public class Kadane {

	public static void main(String[] args) {
		int[] arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		int n = arr.length;
		int max_so_far = arr[0];
		int curr_max = arr[0];

		for (int i = 1; i < n; i++) {
			curr_max = Math.max(arr[i], curr_max + arr[i]);
			max_so_far = Math.max(max_so_far, curr_max);
		}
		System.out.println(max_so_far);

	}

}
