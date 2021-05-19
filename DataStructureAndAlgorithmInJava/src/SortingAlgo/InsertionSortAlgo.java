package SortingAlgo;
import java.util.*;

public class InsertionSortAlgo {

	private static int N;
	private static int arr[];
	
	public InsertionSortAlgo(int n) {
		this.N=n;
		arr=new int[N];
	}
	
	public void insertionSort() {
		for(int i=1;i<N;i++) {
			int temp=arr[i];
			int j=i-1;
			for(;j>=0 && arr[j]>temp;j--) {
				arr[j+1]=arr[j];
			}
			arr[j+1]=temp;
		}
	}
	
	public void printArray() {
		for(int i=0;i<N;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		InsertionSortAlgo obj = new InsertionSortAlgo(n);
		for(int i=0;i<n;i++) {
			arr[i]=sc.nextInt();
		}
		
		System.out.println("Array before sorting:- ");
		obj.printArray();
		obj.insertionSort();
		System.out.println("Array after sorting:- ");
		obj.printArray();

	}

}
