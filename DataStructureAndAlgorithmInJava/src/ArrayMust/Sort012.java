package ArrayMust;

//0 0 1 2 2 
public class Sort012 {

	public static void main(String[] args) {
		int n = 5;
		int arr[] = { 0, 2, 1, 2, 0 };

		int low = 0;
		int mid = 0;
		int high = n - 1;
		while (mid <= high) {
			if (arr[mid] == 0) {
				int temp = arr[mid];
				arr[mid] = arr[low];
				arr[low] = temp;
				low++;
				mid++;
			} else if (arr[mid] == 1) {
				mid++;
			} else if (arr[mid] == 2) {
				int temp = arr[mid];
				arr[mid] = arr[high];
				arr[high] = temp;
				high--;
			}
		}

		for (int x : arr) {
			System.out.print(x + " ");
		}
	}

}
