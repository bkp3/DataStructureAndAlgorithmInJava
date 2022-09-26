package ArrayMust;
//10

public class TrappingRainWater {

	public static void main(String[] args) {
		int n = 6;
		int arr[] = { 3, 0, 0, 2, 0, 4 };

		int i = 0;
		int j = n - 1;

		int l_max = 0;
		int r_max = 0;

		int ans = 0;

		while (i <= j) {
			if (l_max >= r_max) {
				ans = ans + Math.max(0, r_max - arr[j]);
				r_max = Math.max(r_max, arr[j]);
				j--;
			} else {
				ans = ans + Math.max(0, l_max - arr[i]);
				l_max = Math.max(l_max, arr[i]);
				i++;
			}
		}
		System.out.println(ans);

	}

}
