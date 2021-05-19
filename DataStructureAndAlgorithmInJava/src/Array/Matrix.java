package Array;
import java.util.*;
public class Matrix {
	
	private int n;
	private int mat[][];
	
	public Matrix(int n) {
		this.n=n;
		mat=new int[n][n];
	}
	
	public void print() {
		System.out.println("Elements in matrix are:- ");
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				System.out.print(mat[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter size of matrix:- ");
		int n = sc.nextInt();
		Matrix obj = new Matrix(n);
		
		System.out.println("Insert elements in matrix:- ");
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				obj.mat[i][j]=sc.nextInt();
			}
		}
		
		obj.print();
		
		
		
		
	}

}
