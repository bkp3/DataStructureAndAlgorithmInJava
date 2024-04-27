package Array;

//2 0
public class SearchSortedMat {

	public static void main(String[] args) {
		int mat[][] = { { 10, 20, 30, 40 }, { 15, 25, 35, 45 }, { 27, 29, 37, 48 }, { 32, 33, 39, 50 } };

		int x = 27;
		int n = mat.length;
		int i = 0;
		int j = n - 1;

		while (i < n && j >= 0) {
			if (mat[i][j] == x) {
				System.out.println(i + " " + j);
				break;
			}
			if (mat[i][j] > x) {
				j--;
			} else {
				i++;
			}
		}

	}

}
