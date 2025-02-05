package SDE_ArraysI;

/*

Given a matrix if an element in the matrix is 0 then you will have to set its entire column and row to 0 and then return the matrix.


0 1 2 0 
3 4 5 2 
1 3 1 5 
ans:-
0 0 0 0 
0 4 5 0 
0 3 1 0 




*/
public class SetMatrixZeroes {

	// brute force approach Time O(n^3)
	public static void setZeroesI(int[][] mat, int m, int n) {

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (mat[i][j] == 0) {
					for (int k = 0; k < n; k++) {
						if (mat[i][k] >= 1) {
							mat[i][k] = -1;
						}
					}
					for (int k = 0; k < m; k++) {
						if (mat[k][j] >= 1) {
							mat[k][j] = -1;
						}
					}
				}
			}
		}
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (mat[i][j] == -1) {
					mat[i][j] = 0;
				}

			}
		}

	}

	// better approach
	public static void setZeroesII(int[][] mat, int m, int n) {
		int[] row = new int[m];
		int[] col = new int[n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (mat[i][j] == 0) {
					row[i] = 1;
					col[j] = 1;
				}
			}
		}

		for (int i = 0; i < m; i++) {
			System.out.print(row[i] + " ");
		}
		System.out.println();
		for (int j = 0; j < n; j++) {
			System.out.print(col[j] + " ");
		}
		System.out.println();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (row[i] == 1 || col[j] == 1) {
					mat[i][j] = 0;
				}
			}
		}

	}

	// most optimized solution
	public static void setZeroesIII(int[][] mat, int m, int n) {
		int col0 = 1;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (mat[i][j] == 0) {
					mat[i][0] = 0;
					if (j != 0) {
						mat[0][j] = 0;
					} else {
						col0 = 0;
					}
				}
			}
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (mat[i][j] != 0) {
					if (mat[i][0] == 0 || mat[0][j] == 0) {
						mat[i][j] = 0;
					}
				}
			}
		}
		if (mat[0][0] == 0) {
			for (int j = 0; j < n; j++) {
				mat[0][j] = 0;
			}
		}
		if (col0 == 0) {
			for (int i = 0; i < m; i++) {
				mat[i][0] = 0;
			}
		}
	}

	public static void main(String[] args) {
		int[][] mat = { { 0, 1, 2, 0 }, { 3, 4, 5, 2 }, { 1, 3, 1, 5 } };
		int m = mat.length;
		int n = mat[0].length;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}

		setZeroesIII(mat, m, n);

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}

	}

}
