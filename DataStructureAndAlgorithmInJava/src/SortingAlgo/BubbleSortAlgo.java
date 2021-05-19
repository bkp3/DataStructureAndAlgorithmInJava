package SortingAlgo;
import java.util.*;
public class BubbleSortAlgo {

	private static int N;
	private static int arr[];
	
	public BubbleSortAlgo(int n) {
		this.N=n;
		arr=new int[N];
	}
	
	public void bubbleSort() {
		for(int i=0;i<N-1;i++) {
			for(int j=0;j<N-i-1;j++) {
				if(arr[j]>arr[j+1]) {
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
		}
	}
	
	public void printArray() {
		for(int i=0;i<N;i++) {
			System.out.print(arr[i]+" ");
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		BubbleSortAlgo obj = new BubbleSortAlgo(n);
		
		for(int i=0;i<n;i++) {
			arr[i]=sc.nextInt();
		}
		
		System.out.println("Array before sorting:- ");
		obj.printArray();
		System.out.println();
		obj.bubbleSort();
		System.out.println("Array after sorting:- ");
		obj.printArray();

	}

}
